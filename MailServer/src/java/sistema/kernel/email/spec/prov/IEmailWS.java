/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.spec.prov;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.EmailDTO;
import model.PasteDTO;
import tmail.model.ont.Paste;

/**
 *
 * @author Thyago
 */
@WebService(name = "IEmailWS")
public interface IEmailWS {

    @WebMethod(operationName = "sendEmail")
    public boolean sendEmail(@WebParam(name = "idUserSent") String idUserSent,
            @WebParam(name = "idUserReceived") String idUserReceived,
            @WebParam(name = "sentDate") String sentDate,
            @WebParam(name = "subject") String subject,
            @WebParam(name = "message") String message,
            @WebParam(name = "idPaste") String idPaste);

    @WebMethod(operationName = "deleteEmail")
    public boolean deleteEmail(@WebParam(name = "idEmail") String idEmail);

    @WebMethod(operationName = "getEmail")
    public EmailDTO getEmail(@WebParam(name = "idEmail") String idEmail);

    @WebMethod(operationName = "getSentEmailsByUser")
    public List<EmailDTO> getSentEmailsByUser(@WebParam(name = "idUser") String idUser);

    @WebMethod(operationName = "getReceivedEmailsByUser")
    public List<EmailDTO> getReceivedEmailsByUser(@WebParam(name = "idUser") String idUser);

    @WebMethod(operationName = "getReceivedEmailsFromUserByUser")
    public List<EmailDTO> getReceivedEmailsFromUserByUser(@WebParam(name = "idSentUser") String idSentUser,
            @WebParam(name = "idReceivedUser") String idReceivedUser);

    @WebMethod(operationName = "getSentEmailsFromUserByUser")
    public List<EmailDTO> getSentEmailsFromUserByUser(@WebParam(name = "idSentUser") String idSentUser,
            @WebParam(name = "idReceivedUser") String idReceivedUser);

    @WebMethod(operationName = "createPaste")
    public PasteDTO createPaste(@WebParam(name = "name") String name, @WebParam(name = "createdDate") String createdDate, @WebParam(name = "idUser") String idUser);

    @WebMethod(operationName = "deletePaste")
    public boolean deletePaste(@WebParam(name = "idPaste") String idPaste);

    @WebMethod(operationName = "getPaste")
    public PasteDTO getPaste(@WebParam(name = "idPaste") String idPaste);

    @WebMethod(operationName = "getAllPastesByUser")
    public List<PasteDTO> getAllPastesByUser(@WebParam(name = "idUser") String idUser);

    @WebMethod(operationName = "getEmailsByPaste")
    public List<EmailDTO> getEmailsByPaste(@WebParam(name = "idPaste") String idPaste);
}
