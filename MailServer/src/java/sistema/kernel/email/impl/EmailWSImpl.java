/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.impl;

import java.util.*;
import javax.xml.datatype.XMLGregorianCalendar;
import model.EmailDTO;
import model.PasteDTO;
import model.UserDTO;
import sistema.kernel.email.spec.req.ICadastroMgt;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class EmailWSImpl {

    private EmailImpl emailImpl;
    private PasteImpl pasteImpl;
    private ICadastroMgt iCadastroMgtImpl;
    private Manager manager;

    protected EmailWSImpl(Manager manager) {
        this.manager = manager;
        emailImpl = new EmailImpl(manager);
        pasteImpl = new PasteImpl(manager);
    }

    public boolean createEmail(String idUserSent, String idUserReceived, String sentDate, String subject, String message, String idPaste) {
        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");
        User userSent = iCadastroMgtImpl.getUser(idUserSent);


        Set<User> setUsersReceived = new HashSet<User>();

        for (String idUser : idUserReceived.split(";")) {
            User userReceived = iCadastroMgtImpl.getUser(idUser);
            setUsersReceived.add(userReceived);
        }


        Email email = emailImpl.createEmail(userSent, setUsersReceived, sentDate, subject, message, idPaste);
        EmailDTO emailDTO = model.ConvertForDTO.convertEmailForDTO(email);


        if (emailDTO == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteEmail(String idEmail) {
        return emailImpl.deleteEmail(idEmail);
    }

    public EmailDTO getEmail(String idEmail) {

        Email email = emailImpl.getEmail(idEmail);
        EmailDTO emailDTO = model.ConvertForDTO.convertEmailForDTO(email);
        return emailDTO;
    }

    public List<EmailDTO> getSentEmailsByUser(String idUser) {
        List<Email> emails = emailImpl.getSentEmailsByUser(idUser);

        HashSet<EmailDTO> emailsDTO = model.ConvertForDTO.convertEmailsForEmailDTO(new HashSet<Email>(emails));

        return new ArrayList<EmailDTO>(emailsDTO);
    }

    public List<EmailDTO> getReceivedEmailsByUser(String idUser) {
        List<Email> emails = emailImpl.getReceivedEmailsByUser(idUser);

        HashSet<EmailDTO> emailsDTO = model.ConvertForDTO.convertEmailsForEmailDTO(new HashSet<Email>(emails));

        return new ArrayList<EmailDTO>(emailsDTO);
    }

    public List<EmailDTO> getReceivedEmailsFromUserByUser(String idSentUser, String idReceivedUser) {
        List<Email> emails = emailImpl.getReceivedEmailsFromUserByUser(idSentUser, idReceivedUser);

        HashSet<EmailDTO> emailsDTO = model.ConvertForDTO.convertEmailsForEmailDTO(new HashSet<Email>(emails));

        return new ArrayList<EmailDTO>(emailsDTO);
    }

    public List<EmailDTO> getSentEmailsFromUserByUser(String idSentUser, String idReceivedUser) {
        List<Email> emails = emailImpl.getSentEmailsFromUserByUser(idSentUser, idReceivedUser);

        HashSet<EmailDTO> emailsDTO = model.ConvertForDTO.convertEmailsForEmailDTO(new HashSet<Email>(emails));

        return new ArrayList<EmailDTO>(emailsDTO);
    }

    public PasteDTO createPaste(String name, String createdDate, String idUser) {
        Paste paste = pasteImpl.createPaste(name, createdDate, idUser);

        return model.ConvertForDTO.convertPasteForDTO(paste);
    }

    public boolean deletePaste(String idPaste) {
        return pasteImpl.deletePaste(idPaste);
    }

    public PasteDTO updatePaste(Paste paste) {
        paste = pasteImpl.updatePaste(paste);

        return model.ConvertForDTO.convertPasteForDTO(paste);
    }

    public PasteDTO getPaste(String idPaste) {
        Paste paste = pasteImpl.getPaste(idPaste);

        return model.ConvertForDTO.convertPasteForDTO(paste);
    }

    public List<PasteDTO> getAllPastesByUser(String idUser) {
        HashSet<Paste> pastes = new HashSet<Paste>(pasteImpl.getAllPastesByUser(idUser));
        HashSet<PasteDTO> pastesDTO = model.ConvertForDTO.convertPastesForPasteDTO(pastes);

        return new ArrayList<PasteDTO>(pastesDTO);
    }

    public List<EmailDTO> getEmailsByPaste(String idPaste) {
        HashSet<Email> emails = new HashSet<Email>(pasteImpl.getEmailsByPaste(idPaste));
        HashSet<EmailDTO> emailsDTO = model.ConvertForDTO.convertEmailsForEmailDTO(emails);

        return new ArrayList<EmailDTO>(emailsDTO);
    }
}
