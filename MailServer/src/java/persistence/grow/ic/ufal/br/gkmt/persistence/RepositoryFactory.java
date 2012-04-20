/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.grow.ic.ufal.br.gkmt.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;

/**
 * @author endhe
 */
public class RepositoryFactory {

    private static Repository repository = null;
    private static String repositoryURL = "http://localhost:8084/openrdf-sesame/repositories/mailserver";

    protected static Repository getRepository() {
        if (repository == null) {
            repository = new HTTPRepository(repositoryURL);

            try {
                repository.initialize();
            } catch (RepositoryException ex) {
                Logger.getLogger(RepositoryFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return repository;
    }
}
