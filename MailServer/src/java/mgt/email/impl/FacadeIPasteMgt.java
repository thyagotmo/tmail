package mgt.email.impl;

import java.util.List;
import mgt.email.spec.prov.IPasteMgt;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;

class FacadeIPasteMgt implements IPasteMgt, sistema.kernel.email.spec.req.IPasteMgt {

    private PasteMgtImpl pasteMgtImpl;

    public FacadeIPasteMgt(Manager manager) {
        pasteMgtImpl = new PasteMgtImpl(manager);
    }

    @Override
    public Paste createPaste(String idPaste) {
        return pasteMgtImpl.createPaste(idPaste);
    }

    @Override
    public boolean deletePaste(String idPaste) {
        return pasteMgtImpl.deletePaste(idPaste);
    }

    @Override
    public Paste updatePaste(Paste paste) {
        return pasteMgtImpl.updatePaste(paste);
    }

    @Override
    public Paste getPaste(String idPaste) {
        return pasteMgtImpl.getPaste(idPaste);
    }

    @Override
    public List<Paste> getAllPastesByUser(String idUser) {
        return pasteMgtImpl.getAllPastesByUser(idUser);
    }

    @Override
    public List<Email> getEmailsByPaste(String idPaste) {
        return pasteMgtImpl.getEmailsByPaste(idPaste);
    }
}
