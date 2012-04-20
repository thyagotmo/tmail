/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Thyago
 */
@WebService(name="IInitServer")
public interface IInitServer {
    
    
    @WebMethod(operationName="initServer")
    public boolean initServer();
    
}
