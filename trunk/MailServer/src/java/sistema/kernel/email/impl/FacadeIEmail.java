package sistema.kernel.email.impl;

import java.util.List;
import java.util.Set;
import sistema.kernel.email.spec.prov.IEmail;
import tmail.model.ont.Email;
import tmail.model.ont.User;

class FacadeIEmail implements IEmail {

    //Declaração de variáveis
    private EmailImpl emailImpl;

    protected FacadeIEmail(Manager manager) {
        this.emailImpl = new EmailImpl(manager);
    }

    @Override
    public Email createEmail(User userSent, Set<User> usersReceived, String sentDate, String subject, String message, String idPaste) {
        return emailImpl.createEmail(userSent, usersReceived, sentDate, subject, message, idPaste);
    }

    @Override
    public boolean deleteEmail(String idEmail) {
        return emailImpl.deleteEmail(idEmail);
    }

    @Override
    public List<Email> getSentEmailsByUser(String idUser) {
        return emailImpl.getSentEmailsByUser(idUser);
    }

    @Override
    public List<Email> getReceivedEmailsByUser(String idUser) {
        return emailImpl.getReceivedEmailsByUser(idUser);
    }

    @Override
    public List<Email> getSentEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        return emailImpl.getSentEmailsFromUserByUser(idUserSent, idUserReceived);
    }

    @Override
    public List<Email> getReceivedEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        return emailImpl.getReceivedEmailsFromUserByUser(idUserSent, idUserReceived);
    }

    @Override
    public Email getEmail(String idEmail) {
        return emailImpl.getEmail(idEmail);
    }
}
