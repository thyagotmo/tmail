/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.impl;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import javax.xml.datatype.XMLGregorianCalendar;
import sistema.kernel.email.spec.req.ICadastroMgt;
import sistema.kernel.email.spec.req.IEmailMgt;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class EmailImpl {

    private Manager manager;
    private IEmailMgt iEmailMgtImpl;
    private ICadastroMgt iCadastroMgtImpl;

    protected EmailImpl(Manager manager) {
        this.manager = manager;
    }

    public Email createEmail(User userSent, Set<User> usersReceived, String sentDate, String subject, String message, String idPaste) {

        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");

        String idEmail = generateIdEmail(userSent, usersReceived);

        Email email = iEmailMgtImpl.createEmail(idEmail);

        String[] dates = sentDate.split(";");

        String[] datePart = dates[0].split("/");

        int year = Integer.parseInt(datePart[2]);
        int month = Integer.parseInt(datePart[1]);
        int day = Integer.parseInt(datePart[0]);

        String[] timePart = dates[1].split(":");

        int hour = Integer.parseInt(timePart[0]);
        int minute = Integer.parseInt(timePart[1]);
        int second = Integer.parseInt(timePart[2]);


        GregorianCalendar calendar = new GregorianCalendar();

        calendar.set(year, month, day, hour, minute, second);
        XMLGregorianCalendar XMLCalendar = new XMLGregorianCalendarImpl(calendar);

        email.setDateSent(XMLCalendar);
        email.setId(idEmail);
        email.setMessage(message);
        email.setReceiveUser(usersReceived);
        email.setSendUser(userSent);
        email.setSubject(subject);

        email = iEmailMgtImpl.updateEmail(email);


        Set<Email> emails = userSent.getSentEmails();
        emails.add(email);

        for (User user : usersReceived) {
            Set<Email> ReceivedEmails = user.getReceivedEmails();
            ReceivedEmails.add(email);

            iCadastroMgtImpl.updateUser(user);

        }

        iCadastroMgtImpl.updateUser(userSent);


        PasteImpl pasteImpl = new PasteImpl(manager);
        Paste paste = pasteImpl.getPaste(idPaste);

        Set<Email> emailsPaste = paste.getHas_Emails();
        emailsPaste.add(email);


        pasteImpl.updatePaste(paste);


        return email;

    }

    public boolean deleteEmail(String idEmail) {
        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        return iEmailMgtImpl.deleteEmail(idEmail);
    }

    public List<Email> getSentEmailsByUser(String idUser) {

        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");

        return iEmailMgtImpl.getSentEmailsByUser(idUser);
    }

    public List<Email> getReceivedEmailsByUser(String idUser) {
        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        return iEmailMgtImpl.getReceivedEmailsByUser(idUser);
    }

    public List<Email> getSentEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        return iEmailMgtImpl.getEmailsFromUserByUser(idUserSent, idUserReceived);
    }

    public List<Email> getReceivedEmailsFromUserByUser(String idUserSent, String idUserReceived) {
        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        return iEmailMgtImpl.getEmailsFromUserByUser(idUserSent, idUserReceived);
    }

    public Email getEmail(String idEmail) {
        iEmailMgtImpl = (IEmailMgt) this.manager.getRequiredInterface("IEmailMgt");
        return iEmailMgtImpl.getEmail(idEmail);
    }

    private synchronized String generateIdEmail(User userSent, Set<User> userReceived) {
        String loginSentUser = userSent.getLogin();
        String loginReceivedUser = userReceived.iterator().next().getLogin();

        GregorianCalendar calendar = new GregorianCalendar();
        long time = calendar.getTimeInMillis();

        String id = loginSentUser + "_" + loginReceivedUser + "_" + time;

        return id;

    }
}
