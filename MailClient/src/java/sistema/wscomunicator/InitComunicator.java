/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.wscomunicator;

import sistema.wscomunicator.iinitserver.ConfigService;
import sistema.wscomunicator.iinitserver.IInitServer;

/**
 *
 * @author Thyago
 */
public class InitComunicator {

    private IInitServer initServerWSImpl;

    public InitComunicator() {
        ConfigService initService = new ConfigService();
        initServerWSImpl = initService.getConfigPort();
    }

    public IInitServer getInitServerImpl() {
        return initServerWSImpl;
    }
}
