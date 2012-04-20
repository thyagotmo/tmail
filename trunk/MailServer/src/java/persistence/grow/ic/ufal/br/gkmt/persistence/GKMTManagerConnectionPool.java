
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.grow.ic.ufal.br.gkmt.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManager;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;

/**
 *
 * @author endhe
 */
public class GKMTManagerConnectionPool implements ManagerConnectionPool {

    private static final GKMTManagerConnectionPool MANAGER = new GKMTManagerConnectionPool();
    private Map<SesameManager, Boolean> managerState; //serve para saber se o manager já está em uso.
    private Map<SesameManager, RepositoryConnection> managerConnection; //Evita fica chamando manager.getConnection();
    private Map<RepositoryConnection, Set<Object>> connectionObjects; //serve para dar o update.
    private Set<SesameManager> poolManager; //o que implica uma pool de connection!
    private SesameManagerFactory factory;
    private ElmoModule module;
    private Repository repository;

    private GKMTManagerConnectionPool() {
        repository = RepositoryFactory.getRepository();
        module = new ElmoModule();
        factory = new SesameManagerFactory(module, repository);
        this.connectionObjects = new HashMap<RepositoryConnection, Set<Object>>();
        this.managerConnection = new HashMap<SesameManager, RepositoryConnection>();
        this.managerState = new HashMap<SesameManager, Boolean>();
        this.poolManager = new HashSet<SesameManager>();
    }

    public SesameManager getSesameManager() {
        SesameManager manager = null;

        if (!this.allManagerAreBusy() && !poolManager.isEmpty()) {
            for (SesameManager m : managerState.keySet()) {
                boolean isBusy = managerState.get(m);
                if (!isBusy) {
                    this.managerState.put(m, true);
                    return m;
                }
            }

        } else {
            manager = factory.createElmoManager();
            RepositoryConnection repositoryConnection = manager.getConnection();

            this.poolManager.add(manager);
            this.connectionObjects.put(repositoryConnection, new HashSet<Object>());
            this.managerState.put(manager, true);
            this.managerConnection.put(manager, repositoryConnection);
        }

        return manager;
    }

    public void returnSesameManagerToPool(SesameManager manager) {
        this.managerState.put(manager, false);
    }

    private boolean allManagerAreBusy() {
        for (SesameManager manager : managerState.keySet()) {
            boolean isBusy = managerState.get(manager);
            if (!isBusy) {
                return false;
            }
        }

        return true;
    }

    public void addObjectInConnection(RepositoryConnection repositoryConnection, Object object) {
        Set<Object> objects = this.connectionObjects.get(repositoryConnection);

        for (RepositoryConnection connection : this.connectionObjects.keySet()) {
            Set<Object> objectsOnConnection = this.connectionObjects.get(connection);
            if (objectsOnConnection.contains(object)) {
                objectsOnConnection.remove(object);
                connectionObjects.put(connection, objectsOnConnection);
            }
        }
        objects.add(object);
        this.connectionObjects.put(repositoryConnection, objects);
    }

    public void addObjectInConnection(RepositoryConnection repositoryConnection, Set<Object> object) {
        for (RepositoryConnection connection : this.connectionObjects.keySet()) {
            Set<Object> objectsOnConnection = this.connectionObjects.get(connection);
            for (Object ob : object) {
                if (objectsOnConnection.contains(ob)) {
                    objectsOnConnection.remove(ob);
                    connectionObjects.put(connection, objectsOnConnection);
                }
            }
        }

        Set<Object> objectsInConnection = this.connectionObjects.get(repositoryConnection);
        objectsInConnection.addAll(object);
        connectionObjects.put(repositoryConnection, objectsInConnection);
    }

    public RepositoryConnection getConnection(SesameManager manager) {
        RepositoryConnection repositoryConnection = this.managerConnection.get(manager);
        return repositoryConnection;
    }

    public RepositoryConnection getConnectionRelatedObject(Object object) {

        for (RepositoryConnection connection : this.connectionObjects.keySet()) {
            Set<Object> objectsOnConnection = this.connectionObjects.get(connection);
            if (objectsOnConnection.contains(object)) {
                return connection;
            }
        }
        return null;
    }

    protected synchronized static GKMTManagerConnectionPool getManagerConnectionPool() {
        return MANAGER;
    }

    @Override
    public void removeConnectionObject(Object object) {
        try {
            RepositoryConnection repositoryConnection = this.getConnectionRelatedObject(object);
            Set<Object> objectsOnConnection = this.connectionObjects.get(repositoryConnection);

            objectsOnConnection.remove(object);

            this.connectionObjects.put(repositoryConnection, objectsOnConnection);

        } catch (NullPointerException e) {
            throw new ObjectWithoutConnection();
        }


    }
}
