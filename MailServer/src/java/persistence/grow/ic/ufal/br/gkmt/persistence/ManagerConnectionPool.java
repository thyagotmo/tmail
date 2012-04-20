/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.grow.ic.ufal.br.gkmt.persistence;

import java.util.Set;
import org.openrdf.elmo.sesame.SesameManager;
import org.openrdf.repository.RepositoryConnection;

/**
 *Falta colocar as excecoes
 * @author endhe
 */
public interface ManagerConnectionPool {

    public SesameManager getSesameManager();

    public void returnSesameManagerToPool(SesameManager manager);

    public void addObjectInConnection(RepositoryConnection repositoryConnection, Object object);

    public void addObjectInConnection(RepositoryConnection repositoryConnection, Set<Object> object);
    
    public void removeConnectionObject(Object object) throws ObjectWithoutConnection;

    public RepositoryConnection getConnection(SesameManager manager);

    public RepositoryConnection getConnectionRelatedObject(Object object);
}
