/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgt.email.impl;

import java.util.*;
import mgt.email.spec.req.ICadastroMgt;
import persistence.kao.OntologyKAO;
import persistence.utils.URIConstantes;
import tmail.model.ont.Email;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class EmailMgtImpl {

    private Manager manager;
    private ICadastroMgt iCadastroMgtImpl;

    protected EmailMgtImpl(Manager manager) {
        this.manager = manager;
    }

    public Email createEmail(String idEmail) {

        OntologyKAO kao = new OntologyKAO(Email.class);
        Email email = kao.create(URIConstantes.TMAIL, idEmail);

        return email;

    }

    public Email updateEmail(Email email) {
        OntologyKAO kao = new OntologyKAO(Email.class);
        email = kao.update(email);


        return email;
    }

    public boolean deleteEmail(String idEmail) {
        try {
            OntologyKAO kao = new OntologyKAO(Email.class);
            kao.delete(URIConstantes.TMAIL, idEmail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Email getEmail(String idEmail) {
        OntologyKAO kao = new OntologyKAO(Email.class);
        Email email = kao.retrieveInstance(URIConstantes.TMAIL, idEmail);

        return email;
    }

    public List<Email> getSentEmailsByUser(String idUser) {
        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");
        User user = iCadastroMgtImpl.getUser(idUser);

        List<Email> emails = new ArrayList<Email>(user.getSentEmails());

        return emails;
    }

    public List<Email> getReceivedEmailsByUser(String idUser) {

        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");
        User user = iCadastroMgtImpl.getUser(idUser);

        List<Email> emails = new ArrayList<Email>(user.getReceivedEmails());

        return emails;
    }

    public List<Email> getEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");

        User userSent = iCadastroMgtImpl.getUser(idUserSent);
        User userReceived = iCadastroMgtImpl.getUser(idUserReceived);

        List<Email> emails = new ArrayList<Email>();

        for (Email email : userSent.getSentEmails()) {
            Set<User> usersReceivedEmail = email.getReceiveUser();


            for (User user : usersReceivedEmail) {
                if (user.getLogin().equals(userReceived.getLogin())) {
                    emails.add(email);
                    break;
                }
            }

        }

        return emails;

    }
    
}
