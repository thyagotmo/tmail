/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.wscomunicator;

import sistema.wscomunicator.iinitserver.IInitServer;
import sistema.wscomunicator.ilogin.FacadeILoginWSService;
import sistema.wscomunicator.ilogin.ILoginWS;

/**
 *
 * @author Thyago
 */
public class LoginComunicator {

    private static LoginComunicator comunicatorInstance;
    private static boolean controlSingleton = false;
    private ILoginWS loginWSImpl;

    private LoginComunicator() {
        FacadeILoginWSService serviceLogin = new FacadeILoginWSService();
        loginWSImpl = serviceLogin.getFacadeILoginWSPort();

        InitComunicator comunicator = new InitComunicator();
        IInitServer init = comunicator.getInitServerImpl();
        init.initServer();
    }

    public ILoginWS getLoginImpl() {
        return loginWSImpl;
    }

    public static LoginComunicator getInstance() {
        if (!controlSingleton) {
            comunicatorInstance = new LoginComunicator();
            controlSingleton = true;
        }

        return comunicatorInstance;
    }
}
