package mgt.email.impl;

import java.util.List;
import mgt.email.spec.prov.IEmailMgt;
import tmail.model.ont.Email;

class FacadeIEmailMgt implements IEmailMgt, sistema.kernel.email.spec.req.IEmailMgt {

    //Declaração de variáveis
    private EmailMgtImpl emailMgtImpl;

    protected FacadeIEmailMgt(Manager manager) {
        this.emailMgtImpl = new EmailMgtImpl(manager);
    }

    @Override
    public Email createEmail(String idEmail) {
        return emailMgtImpl.createEmail(idEmail);
    }

    @Override
    public boolean deleteEmail(String idEmail) {
        return emailMgtImpl.deleteEmail(idEmail);
    }

    @Override
    public List<Email> getSentEmailsByUser(String idUser) {
        return emailMgtImpl.getSentEmailsByUser(idUser);
    }

    @Override
    public List<Email> getReceivedEmailsByUser(String idUser) {
        return emailMgtImpl.getReceivedEmailsByUser(idUser);
    }

    @Override
    public List<Email> getEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        return emailMgtImpl.getEmailsFromUserByUser(idUserSent, idUserReceived);
    }

    @Override
    public Email getEmail(String idEmail) {
        return emailMgtImpl.getEmail(idEmail);
    }

    @Override
    public Email updateEmail(Email email) {
        return emailMgtImpl.updateEmail(email);
    }
}
