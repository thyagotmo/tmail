/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.wscomunicator;

import sistema.wscomunicator.icadastro.FacadeICadastroWSService;
import sistema.wscomunicator.icadastro.ICadastroWS;
import sistema.wscomunicator.iinitserver.IInitServer;

/**
 *
 * @author Thyago
 */
public class CadastroComunicator {

    private static CadastroComunicator comunicatorInstance;
    private static boolean controlSingleton = false;
    private ICadastroWS cadastroWSImpl;

    private CadastroComunicator() {
        FacadeICadastroWSService serviceCadastro = new FacadeICadastroWSService();
        cadastroWSImpl = serviceCadastro.getFacadeICadastroWSPort();

        InitComunicator comunicator = new InitComunicator();
        IInitServer init = comunicator.getInitServerImpl();
        init.initServer();
    }

    public ICadastroWS getCadastroImpl() {
        return cadastroWSImpl;
    }

    public static CadastroComunicator getInstance() {
        if (!controlSingleton) {
            comunicatorInstance = new CadastroComunicator();
            controlSingleton = true;
        }

        return comunicatorInstance;
    }
}
