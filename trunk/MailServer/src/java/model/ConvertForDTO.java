/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.xml.datatype.XMLGregorianCalendar;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public class ConvertForDTO {

    public static UserDTO convertUserFotDTO(User user) {
        UserDTO userDTO = new UserDTO();


        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setGender(user.getGender());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());

        GregorianCalendar calendar = user.getBirthDay().toGregorianCalendar();
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH);

        String date = day + "/" + month + "/" + year;

        userDTO.setBirthDay(date);

        Set<Paste> pastes = user.getPastes();

        return userDTO;

    }

    public static HashSet<UserDTO> convertUsersForUserDTO(Set<User> users) {

        HashSet<UserDTO> usersDTO = new HashSet<UserDTO>();

        for (User user : users) {
            UserDTO userDTO = convertUserFotDTO(user);
            usersDTO.add(userDTO);
        }

        return usersDTO;

    }

    public static EmailDTO convertEmailForDTO(Email email) {
        EmailDTO emailDTO = new EmailDTO();

        Set<User> receiveUser = email.getReceiveUser();
        User sentUser = email.getSendUser();

        emailDTO.setId(email.getId());
        emailDTO.setMessage(email.getMessage());
        emailDTO.setReceivedUser(convertUsersForUserDTO(receiveUser));
        emailDTO.setSentUser(convertUserFotDTO(sentUser));
        emailDTO.setSubject(email.getSubject());

        XMLGregorianCalendar XMLCalendar = email.getDateSent();
        GregorianCalendar calendar = XMLCalendar.toGregorianCalendar();

        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month = calendar.get(GregorianCalendar.MONTH);
        int year = calendar.get(GregorianCalendar.YEAR);


        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String date = day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second;

        emailDTO.setDateSent(date);

        return emailDTO;
    }

    public static HashSet<EmailDTO> convertEmailsForEmailDTO(Set<Email> emails) {

        HashSet<EmailDTO> emailsDTO = new HashSet<EmailDTO>();

        for (Email email : emails) {
            EmailDTO emailDTO = convertEmailForDTO(email);
            emailsDTO.add(emailDTO);
        }

        return emailsDTO;

    }

    public static PasteDTO convertPasteForDTO(Paste paste) {
        PasteDTO pasteDTO = new PasteDTO();

        pasteDTO.setName(paste.getName());

        GregorianCalendar calendar = paste.getCreateDate().toGregorianCalendar();
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH);

        String date = day + "/" + month + "/" + year;

        pasteDTO.setCreatedDate(date);

        Set<Email> emails = paste.getHas_Emails();
        pasteDTO.setEmails(convertEmailsForEmailDTO(emails));

        return pasteDTO;

    }

    public static HashSet<PasteDTO> convertPastesForPasteDTO(Set<Paste> pastes) {

        HashSet<PasteDTO> pastesDTO = new HashSet<PasteDTO>();

        for (Paste paste : pastes) {
            PasteDTO pasteDTO = convertPasteForDTO(paste);
            pastesDTO.add(pasteDTO);
        }

        return pastesDTO;

    }
}
