/*
 *
 * COPYRIGHT NOTICE
 *
 */
package persistence.grow.ic.ufal.br.gkmt.persistence;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

import javax.persistence.NonUniqueResultException;
import javax.xml.namespace.QName;

import org.openrdf.elmo.ElmoQuery;
import org.openrdf.elmo.Entity;
import org.openrdf.elmo.sesame.SesameManager;
import org.openrdf.query.BooleanQuery;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;

/**
 * Abstract class KAO, for operations in the persistence with SESAME
 *
 * @author Olavo Holanda - Massayo
 * @author Endhe Elias - NEES 
 * @version 0.1 - 05/07/2009
 */
//Com essa abordagem deve existir um AbstractKAO para cada entidade,
//recomendação da api do elmo (http://www.openrdf.org/doc/elmo/1.5/user-guide/x137.html).
//Fica mais elegante mudar para interface, e obter as implementações a partir de uma fabrica.
//Assim terimos varias interfaces que herdam da interface AbstractKAO, passando T como Entidade,
//por exemplo Resource.
public abstract class AbstractKAO {

    // VARIABLES
    // ----------------------------------------------------------------------
    // Variable to connect with the repository
//    private Repository repository;
    // Variable to do operations in the repository
    public SesameManager manager; //Permite que os KAOs usem as transacoes em casos especificos
    // Variable to create a SesameManager
    // Variable with the desired class to be implemented
    private Class<?> classe;
//    private String ontologyURI;
//    private EntityTransaction transaction;
    private ManagerConnectionPool managerConnectionPool;
    //This token is used to separate ontologyURI and instanceName
    private final String mainToken = "#";

    // CONSTRUCTOR
    // --------------------------------------------------------------------
    protected Class<?> getClasse() {
        return classe;
    }

    protected void setClasse(Class<?> classe) {
        this.classe = classe;
    }

    /**
     * The constructor will start the repository and create a SesameManager, to
     * make the operations in the persistence
     *
     * @param classe
     *            the .class to be implemented
     */
    public <T> AbstractKAO(Class<T> classe) {
        this.classe = classe;
        this.managerConnectionPool = FactoryManagerConnectionPool.getManagerConnectionPool();
    }

    //Construtor, somente  para consultas.
    public <T> AbstractKAO() {
        this.managerConnectionPool = GKMTManagerConnectionPool.getManagerConnectionPool();
    }

    // METHODS
    // ------------------------------------------------------------------------
    /**
     * Method that implements the interface .class creating the desired
     * instance, must be saved after
     *
     * @param String
     *            ontologyURI, String instanceName
     * @return <code>T Bean</code> the instance created
     */
    @SuppressWarnings("unchecked")
    public <T> T create(String ontologyURI, String instanceName) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        QName qname = new QName(ontologyURI, instanceName);
        T instance = (T) this.manager.designate(qname, this.classe);
        this.manager.getTransaction().commit();

        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnection(manager);
        this.managerConnectionPool.addObjectInConnection(repositoryConnection, instance.toString());
        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return instance;
    }

    public <T> T update(T instance) {
        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnectionRelatedObject(instance.toString());
        try {
            repositoryConnection.commit();
            this.managerConnectionPool.addObjectInConnection(repositoryConnection, instance.toString());
        } catch (RepositoryException ex) {
            try {
                repositoryConnection.rollback();
            } catch (RepositoryException ex1) {
                Logger.getLogger(AbstractKAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(AbstractKAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return instance;
    }

    /**
     * Method to delete the desired instance in the repository, must be saved
     * after
     *
     * @param String
     *            onotologyURI, String instanceName
     */
    public <T> void delete(T instance) {
        String[] uris = instance.toString().split(mainToken);
        String objectOnConnection = instance.toString();
        String ontologyURI = uris[0] + mainToken;
        String instanceName = uris[1];

        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        // Creates an qname with the parameters
        QName qname = new QName(ontologyURI, instanceName);

        // Find the instance desired with the qname
        Entity entity = this.manager.find(qname);

        // remove the instance
        this.manager.remove(entity);

        this.manager.getTransaction().commit();

        this.managerConnectionPool.returnSesameManagerToPool(manager);

        //Necessário pq as vezes, o objeto eh pego através do retrive, outras
        //pela a composição com outros objetos. No segundo caso, o objeto 
        //não tem conexão relacionada.
        try {
            this.managerConnectionPool.removeConnectionObject(objectOnConnection);
        } catch (ObjectWithoutConnection e) {
        }
    }

    /**
     * Method to delete the desired instance in the repository, must be saved
     * after
     *
     * @param String
     *            onotologyURI, String instanceName
     */
    public void delete(String ontologyURI, String instanceName) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        // Creates an qname with the parameters
        QName qname = new QName(ontologyURI, instanceName);

        // Find the instance desired with the qname
        Entity entity = this.manager.find(qname);

        // remove the instance
        this.manager.remove(entity);

        this.manager.getTransaction().commit();

        this.managerConnectionPool.returnSesameManagerToPool(manager);
    }

    /**
     * Method to retrieve the desired instance
     *
     * @param String
     *            onotologyURI, String instanceName
     */
    @SuppressWarnings("unchecked")
    public <T> T retrieveInstance(String ontologyURI, String instanceName) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();

        // Creates an qname with the parameters
        QName qname = new QName(ontologyURI, instanceName);
        T instance = (T) this.manager.find(this.classe, qname);
        // Find the instance desired with the qname and the .class
        this.manager.getTransaction().commit();

        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnection(manager);


        if (instance != null) {
            this.managerConnectionPool.addObjectInConnection(repositoryConnection, instance.toString());
        }
        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return instance;

    }

    /**
     * Method to retrieve all the instances of the class, passed in the
     * constructor
     *
     * @return <code>Iterable</code> with the instances
     */
    public <T> Set<T> retrieveAllInstances() {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        Iterable<T> itb = (Iterable<T>) this.manager.findAll(this.classe);
        Iterator<T> iterator = itb.iterator();
        Set<T> allInstances = new HashSet<T>();
        while (iterator.hasNext()) {
            T instance = iterator.next();
            allInstances.add(instance);
        }
        this.manager.getTransaction().commit();

        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnection(manager);

        for (Iterator<T> it = allInstances.iterator(); it.hasNext();) {
            Object object = it.next();
            this.managerConnectionPool.addObjectInConnection(repositoryConnection, object.toString());
        }

        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return allInstances;
    }

    /**
     * Protected method to execute SPARQL queries, in the repository
     *
     * @param String
     *            query
     * @return <code>Iterator</code> with the results
     */
    protected Object executeSPARQLquerySingleResult(String query) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        // creates the query based on the parameter
        ElmoQuery elmoQuery = this.manager.createQuery(query);

        // execute the query
        Object result = null;

        //O Try-Catch eh necessario pq o SesameQuery,
        //lanca duas excecoes nesse tipo de retorno.
        //detalhes em: http://www.openrdf.org/doc/elmo/1.3/xref/org/openrdf/elmo/sesame/SesameQuery.html
        try {
            result = elmoQuery.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        } catch (NonUniqueResultException ex) {
        }

        this.manager.getTransaction().commit();

        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnection(manager);

        if (result != null) {
            this.managerConnectionPool.addObjectInConnection(repositoryConnection, result.toString());
        }
        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return result;
    }

    /**
     * Protected method to execute SPARQL queries, in the repository
     *
     * @param String
     *            query
     * @return <code>Iterator</code> with the results
     */
    protected List executeSPARQLqueryResultList(String query) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();
        // creates the query based on the parameter
        ElmoQuery elmoQuery = this.manager.createQuery(query);

        // execute the query
        List resultList = elmoQuery.getResultList();

        this.manager.getTransaction().commit();

        RepositoryConnection repositoryConnection = this.managerConnectionPool.getConnection(manager);

        for (Iterator it = resultList.iterator(); it.hasNext();) {
            Object object = it.next();
            this.managerConnectionPool.addObjectInConnection(repositoryConnection, object.toString());
        }


        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return resultList;
    }

    /**
     * Protected method to execute boolean SPARQL queries, in the repository
     *
     * @param String
     *            query
     * @return <code>Iterator</code> with the results
     */
    protected Boolean executeBooleanSPARQLquery(String query) {
        this.manager = managerConnectionPool.getSesameManager();

        this.manager.getTransaction().begin();

        boolean retorno = false;

        RepositoryConnection con = this.managerConnectionPool.getConnection(manager);
        try {
            BooleanQuery q = con.prepareBooleanQuery(QueryLanguage.SPARQL, query);

            retorno = q.evaluate();


        } catch (RepositoryException ex) {
            Logger.getLogger(AbstractKAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedQueryException ex) {
            Logger.getLogger(AbstractKAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (QueryEvaluationException ex) {
            Logger.getLogger(AbstractKAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.manager.getTransaction().commit();

        this.managerConnectionPool.returnSesameManagerToPool(manager);

        return retorno;
    }
}
