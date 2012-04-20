/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.cadastro.impl;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.GregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;
import sistema.kernel.cadastro.spec.req.ICadastroMgt;
import sistema.kernel.cadastro.spec.req.IPaste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class CadastroImpl {

    private Manager manager;
    private ICadastroMgt iCadastroMgtImpl;
    private IPaste iPasteImpl;

    public CadastroImpl(Manager manager) {
        this.manager = manager;
    }

    public User registerUser(String firstName, String lastName, String birthDay, String gender, String login, String password) {

        iCadastroMgtImpl = (ICadastroMgt) manager.getRequiredInterface("ICadastroMgt");
        User user = iCadastroMgtImpl.createUser(login);
        String[] datePart = birthDay.split("/");

        int year = Integer.parseInt(datePart[2]);
        int month = Integer.parseInt(datePart[1]);
        int day = Integer.parseInt(datePart[0]);

        GregorianCalendar calendar = new GregorianCalendar();

        int hour = calendar.get(GregorianCalendar.HOUR);
        int minute = calendar.get(GregorianCalendar.MINUTE);
        int second = calendar.get(GregorianCalendar.SECOND);


        calendar.set(year, month, day);
        XMLGregorianCalendar XMLCalendar = new XMLGregorianCalendarImpl(calendar);


        //Setando o usuário
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDay(XMLCalendar);
        user.setGender(gender);
        user.setLogin(login);
        user.setPassword(password);


        user = iCadastroMgtImpl.updateUser(user);


        iPasteImpl = (IPaste) this.manager.getRequiredInterface("IPaste");
        String date = day + "/" + month + "/" + year + ";" + hour + ":" + minute + ":" + second;

        iPasteImpl.createPaste("Itens Enviados", date, login);
        iPasteImpl.createPaste("Caixa de Entrada", date, login);
        iPasteImpl.createPaste("Iten excuídos", date, login);


        return user;
    }

    public boolean updateUserInformation(String login, String newFirstName, String newLastName, String newBirthDay, String newGender) {
        try {
            iCadastroMgtImpl = (ICadastroMgt) manager.getRequiredInterface("ICadastroMgt");

            //Carregando o usuário
            User user = this.getUser(login);

            String[] datePart = newBirthDay.split("/");

            int year = Integer.parseInt(datePart[2]);
            int month = Integer.parseInt(datePart[1]);
            int day = Integer.parseInt(datePart[0]);

            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            XMLGregorianCalendar XMLCalendar = new XMLGregorianCalendarImpl(calendar);

            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setBirthDay(XMLCalendar);
            user.setGender(newGender);

            iCadastroMgtImpl.updateUser(user);


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String login, String newPassword) {

        try {
            iCadastroMgtImpl = (ICadastroMgt) manager.getRequiredInterface("ICadastroMgt");

            //Pegar o usuário
            User user = this.getUser(login);

            user.setPassword(newPassword);

            iCadastroMgtImpl.updateUser(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(String idUser) {

        iCadastroMgtImpl = (ICadastroMgt) manager.getRequiredInterface("ICadastroMgt");

        return iCadastroMgtImpl.getUser(idUser);

    }

    public boolean deleteUser(String idUser) {
        iCadastroMgtImpl = (ICadastroMgt) manager.getRequiredInterface("ICadastroMgt");

        return iCadastroMgtImpl.deleteUser(idUser);

    }
}
