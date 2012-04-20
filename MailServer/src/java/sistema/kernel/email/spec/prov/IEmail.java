/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.spec.prov;

import java.util.List;
import java.util.Set;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public interface IEmail {

    public Email createEmail(User userSent, Set<User> usersReceived, String sentDate, String subject, String message, String idPaste);

    public boolean deleteEmail(String idEmail);

    public Email getEmail(String idEmail);

    public List<Email> getSentEmailsByUser(String idUser);

    public List<Email> getReceivedEmailsByUser(String idUser);

    public List<Email> getReceivedEmailsFromUserByUser(String idSentUser, String idReceivedUser);

    public List<Email> getSentEmailsFromUserByUser(String idSentUser, String idReceivedUser);

}
