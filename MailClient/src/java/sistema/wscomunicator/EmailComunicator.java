/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.wscomunicator;

import sistema.wscomunicator.iemail.FacadeIEmailWSService;
import sistema.wscomunicator.iemail.IEmailWS;
import sistema.wscomunicator.iinitserver.IInitServer;

/**
 *
 * @author Thyago
 */
public class EmailComunicator {

    private static EmailComunicator comunicatorInstance;
    private static boolean controlSingleton = false;
    private IEmailWS emailWSImpl;

    private EmailComunicator() {
        FacadeIEmailWSService serviceEmail = new FacadeIEmailWSService();
        emailWSImpl = serviceEmail.getFacadeIEmailWSPort();

        InitComunicator comunicator = new InitComunicator();
        IInitServer init = comunicator.getInitServerImpl();
        init.initServer();
    }

    public IEmailWS getEmailImpl() {
        return emailWSImpl;
    }

    public static EmailComunicator getInstance() {
        if (!controlSingleton) {
            comunicatorInstance = new EmailComunicator();
            controlSingleton = true;
        }

        return comunicatorInstance;
    }
}
