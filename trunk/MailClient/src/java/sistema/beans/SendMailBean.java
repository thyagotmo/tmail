/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.beans;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sistema.wscomunicator.EmailComunicator;
import sistema.wscomunicator.iemail.EmailDTO;
import sistema.wscomunicator.iemail.IEmailWS;

/**
 *
 * @author Thyago
 */
public class SendMailBean implements Serializable {

    private EmailDTO sentMail;
    private String receivedUsers;

    public SendMailBean() {
        sentMail = new EmailDTO();
    }

    public String getReceivedUsers() {
        return receivedUsers;
    }

    public void setReceivedUsers(String receivedUsers) {
        this.receivedUsers = receivedUsers;
    }

    public EmailDTO getSentMail() {
        return sentMail;
    }

    public void setSentMail(EmailDTO sentMail) {
        this.sentMail = sentMail;
    }

    public String sendMail() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String idUserSend = (String) session.getAttribute("idUser");

        EmailComunicator emailComunicator = EmailComunicator.getInstance();
        IEmailWS emailImpl = emailComunicator.getEmailImpl();


        String message = sentMail.getMessage();
        String subject = sentMail.getSubject();
        String sentDate = getActualDateFormated();

        String idPaste = idUserSend + "_" + "ItensEnviados";


        System.out.println("VALORES: " + " -UD: " + idUserSend + " -RU: " + receivedUsers
                + " -SD; " + sentDate + " -s: " + subject + " -m: " + message + " -IP: " + idPaste);

        boolean result = emailImpl.sendEmail(idUserSend, receivedUsers, sentDate, subject, message, idPaste);

        if (result) {
            FacesMessage facesMessage = new FacesMessage("Email enviado com sucesso!");
            FacesContext.getCurrentInstance().addMessage("", facesMessage);

            return "sucessoEnviarEmail";
        } else {
            FacesMessage facesMessage = new FacesMessage("Email não pode ser enviado!");
            FacesContext.getCurrentInstance().addMessage("", facesMessage);

            return null;
        }


    }

    private String getActualDateFormated() {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(GregorianCalendar.HOUR);
        int minute = calendar.get(GregorianCalendar.MINUTE);
        int second = calendar.get(GregorianCalendar.SECOND);

        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month = calendar.get(GregorianCalendar.MONTH);
        int year = calendar.get(GregorianCalendar.YEAR);

        String dateFormated = day + "/" + month + "/" + year + ";" + hour + ":" + minute + ":" + second;

        return dateFormated;
    }
}
