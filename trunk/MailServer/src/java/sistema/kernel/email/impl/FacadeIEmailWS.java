/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.impl;

import java.util.List;
import javax.jws.WebService;
import model.EmailDTO;
import model.PasteDTO;
import sistema.kernel.email.spec.prov.IEmailWS;

/**
 *
 * @author Thyago
 */
@WebService(endpointInterface = "sistema.kernel.email.spec.prov.IEmailWS")
class FacadeIEmailWS implements IEmailWS {

    private EmailWSImpl emailWSImpl;

    public FacadeIEmailWS() {
        Manager manager = Manager.getManager();

        emailWSImpl = new EmailWSImpl(manager);
    }

    @Override
    public boolean sendEmail(String idUserSent, String idUserReceived, String sentDate, String subject, String message, String idPaste) {
        return emailWSImpl.createEmail(idUserSent, idUserReceived, sentDate, subject, message, idPaste);
    }

    @Override
    public boolean deleteEmail(String idEmail) {
        return emailWSImpl.deleteEmail(idEmail);
    }

    @Override
    public EmailDTO getEmail(String idEmail) {
        return emailWSImpl.getEmail(idEmail);
    }

    @Override
    public List<EmailDTO> getSentEmailsByUser(String idUser) {
        return emailWSImpl.getSentEmailsByUser(idUser);
    }

    @Override
    public List<EmailDTO> getReceivedEmailsByUser(String idUser) {
        return emailWSImpl.getReceivedEmailsByUser(idUser);
    }

    @Override
    public List<EmailDTO> getReceivedEmailsFromUserByUser(String idSentUser, String idReceivedUser) {
        return emailWSImpl.getReceivedEmailsFromUserByUser(idSentUser, idReceivedUser);
    }

    @Override
    public List<EmailDTO> getSentEmailsFromUserByUser(String idSentUser, String idReceivedUser) {
        return emailWSImpl.getSentEmailsFromUserByUser(idSentUser, idReceivedUser);
    }

    @Override
    public PasteDTO createPaste(String name, String createdDate, String idUser) {
        return emailWSImpl.createPaste(name, createdDate, idUser);
    }

    @Override
    public boolean deletePaste(String idPaste) {
        return emailWSImpl.deletePaste(idPaste);
    }

    @Override
    public PasteDTO getPaste(String idPaste) {
        return emailWSImpl.getPaste(idPaste);
    }

    @Override
    public List<PasteDTO> getAllPastesByUser(String idUser) {
        return emailWSImpl.getAllPastesByUser(idUser);
    }

    @Override
    public List<EmailDTO> getEmailsByPaste(String idPaste) {
        return emailWSImpl.getEmailsByPaste(idPaste);
    }
}
