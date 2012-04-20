/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgt.email.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import mgt.email.spec.req.ICadastroMgt;
import persistence.kao.OntologyKAO;
import persistence.utils.URIConstantes;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class PasteMgtImpl {

    private Manager manager;
    private ICadastroMgt iCadastroMgtImpl;

    protected PasteMgtImpl(Manager manager) {
        this.manager = manager;
    }

    public Paste createPaste(String idPaste) {
        OntologyKAO kao = new OntologyKAO(Paste.class);
        Paste paste = kao.create(URIConstantes.TMAIL, idPaste);

        return paste;


    }

    public boolean deletePaste(String idPaste) {
        try {
            OntologyKAO kao = new OntologyKAO(Paste.class);
            kao.delete(URIConstantes.TMAIL, idPaste);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Paste updatePaste(Paste paste) {
        OntologyKAO kao = new OntologyKAO(Paste.class);
        paste = kao.update(paste);

        return paste;

    }

    public Paste getPaste(String idPaste) {
        OntologyKAO kao = new OntologyKAO(Paste.class);
        Paste paste = kao.retrieveInstance(URIConstantes.TMAIL, idPaste);

        return paste;
    }

    public List<Paste> getAllPastesByUser(String idUser) {
        iCadastroMgtImpl = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");
        User user = iCadastroMgtImpl.getUser(idUser);

        return new ArrayList<Paste>(user.getPastes());
    }

    public List<Email> getEmailsByPaste(String idPaste) {
        Paste paste = this.getPaste(idPaste);

        return new ArrayList<Email>(paste.getHas_Emails());
    }
}
