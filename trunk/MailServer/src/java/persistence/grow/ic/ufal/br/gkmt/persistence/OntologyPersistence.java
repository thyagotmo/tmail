
/*
 *
 * COPYRIGHT NOTICE
 *
 */

package persistence.grow.ic.ufal.br.gkmt.persistence;

import java.io.File;
import java.net.URL;

import persistence.grow.ic.ufal.br.gkmt.persistence.utils.Configuration;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.rio.RDFFormat;


/**
 * Class responsible for persistence of RDF/OWL 
 * files in the repository
 *  
 * @author Olavo Holanda - Massayo
 * @version 0.1 - 16/04/2010
 */

public class OntologyPersistence {
	
	// VARIABLES ----------------------------------------------------------------------
	
	//Variable to connect with the repository
	private Repository repository;

	//Variable that represents the Connection of the repository
	private RepositoryConnection repoConnection;
	
	//Variable which creates a factory for several operations
	private ValueFactory factory;
	
	//Variable with the repository's URL
	private String repositoryURL= Configuration.getInstance("configuration").getValue("Repository").toString();

	// CONSTRUCTOR --------------------------------------------------------------------
	
	/**
     * The constructor will start the repository and
     * create a ValueFactory, to make the operations
     * in the persistence
     * 
     */	
	
	public OntologyPersistence(){
		
		//Retrieves the repository in the server
		this.repository = new HTTPRepository(this.repositoryURL);
		
		try {
			
			//Starts the repository
			this.repository.initialize();
			
			//Create the factory
			factory = this.repository.getValueFactory();
		} catch (RepositoryException e) {
			
			//Catch the repositoryException
			e.printStackTrace();
		}
	}
	
	// METHODS ------------------------------------------------------------------------
	
	/**
     * Method that persists an ontology file, an RDF, or OWL,
     * in the repository, based on the ontology's URL.
     *
     * @param String ontologyURL
     */	
	public void persist(String ontologyURL){
		
		try {
			//Get repository connection
			this.repoConnection = this.repository.getConnection();
			
			try {
				
				//Set autoCommit to false, in order to do a transaction
				this.repoConnection.setAutoCommit(false);

				//create URL from ontology's URI
				URL url = new URL(ontologyURL.toString());

				//create URI from ontology's URI
				URI uri = this.factory.createURI(ontologyURL.toString());

				//Add the ontology, based on the ontology's URL,
				//in the repository specifying the base URI and the context 
				this.repoConnection.add(url,url.toString(),RDFFormat.RDFXML, uri);

				//commit the changes made in the repository
				this.repoConnection.commit();
			} catch (Exception e) {
				
				//If catch any exception then rollback
				repoConnection.rollback();
				e.printStackTrace();
			} finally {
				
				//close the repository connection 
				this.repoConnection.close();
			}
			
		} catch (RepositoryException repoExc) {
			
			repoExc.printStackTrace();			
		}
	}
	
	/**
     * Method that persists an ontology file, an RDF, or OWL,
     * in the repository, based on the ontology's path.
     *
     * @param String ontologyPath, String ontologyURI
     */	
	public void persist(String ontologyPath, String ontologyURI){

		//create a file specifying the file's path
		File file = new File(ontologyPath);
		
		try {
			//Get repository connection
			this.repoConnection = this.repository.getConnection();
			
			try {
				//Set autoCommit to false, in order to do a transaction
				this.repoConnection.setAutoCommit(false);

				//create URI from ontology's URI
				URI uri = this.factory.createURI(ontologyURI.toString());

				//Add the ontology, based on the ontology's file,
				//in the repository specifying the base URI and the context 
				this.repoConnection.add(file,ontologyURI,RDFFormat.RDFXML, uri);

				//commit the changes made in the repository
				this.repoConnection.commit();
			} catch (Exception e) {
				
				//If catch any exception then rollback
				repoConnection.rollback();
				e.printStackTrace();
			} finally {
				
				//close the repository connection
				this.repoConnection.close();
			}
		} catch (RepositoryException repoExc) {
			
			repoExc.printStackTrace();			
		}
	}
	
	/**
     * Method that closes the repository
     */	
	public void close(){
		try {
			
			//Close the repository
			this.repository.shutDown();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}
	}
}
