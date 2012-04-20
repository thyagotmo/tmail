/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.impl;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.datatype.XMLGregorianCalendar;
import sistema.kernel.email.spec.req.ICadastroMgt;
import sistema.kernel.email.spec.req.IPasteMgt;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public class PasteImpl {

    private Manager manager;
    private IPasteMgt iPasteMgt;
    private ICadastroMgt iCadastroMgt;

    public PasteImpl(Manager manager) {
        this.manager = manager;
    }

    public Paste createPaste(String name, String createdDate, String idUser) {

        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");
        iCadastroMgt = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");

        String[] dates = createdDate.split(";");

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


        String idPaste = idUser + "_" + name.replaceAll(" ", "");

        User user = iCadastroMgt.getUser(idUser);


        Paste paste = iPasteMgt.createPaste(idPaste);

        paste.setCreateDate(XMLCalendar);
        paste.setName(name);
        paste.setHas_User(user);
        paste.setHas_Emails(new HashSet<Email>());

        paste = iPasteMgt.updatePaste(paste);

        Set<Paste> pastesUser = user.getPastes();
        pastesUser.add(paste);
        user.setPastes(pastesUser);

        iCadastroMgt.updateUser(user);

        return paste;

    }

    public boolean deletePaste(String idPaste) {
        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");

        return iPasteMgt.deletePaste(idPaste);
    }

    public Paste updatePaste(Paste paste) {
        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");

        return iPasteMgt.updatePaste(paste);
    }

    public Paste getPaste(String idPaste) {
        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");

        return iPasteMgt.getPaste(idPaste);
    }

    public List<Paste> getAllPastesByUser(String idUser) {
        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");

        return iPasteMgt.getAllPastesByUser(idUser);
    }

    public List<Email> getEmailsByPaste(String idPaste) {
        iPasteMgt = (IPasteMgt) this.manager.getRequiredInterface("IPasteMgt");

        return iPasteMgt.getEmailsByPaste(idPaste);
    }
}
