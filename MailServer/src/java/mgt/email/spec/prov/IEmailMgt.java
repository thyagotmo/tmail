/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgt.email.spec.prov;

import java.util.List;
import tmail.model.ont.Email;

/**
 *
 * @author Thyago
 */
public interface IEmailMgt {

    public Email createEmail(String idEmail);

    public Email updateEmail(Email email);

    public boolean deleteEmail(String idEmail);

    public Email getEmail(String idEmail);

    public List<Email> getSentEmailsByUser(String idUser);

    public List<Email> getReceivedEmailsByUser(String idUser);

    public List<Email> getEmailsFromUserByUser(String idUserSent, String idUserReceived);
}
