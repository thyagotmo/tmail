package sistema.kernel.email.impl;

import java.util.List;
import sistema.kernel.email.spec.prov.IPaste;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;

class FacadeIPaste implements IPaste, sistema.kernel.cadastro.spec.req.IPaste {

    //Declaração de variáveis
    private PasteImpl emailImpl;

    protected FacadeIPaste(Manager manager) {
        this.emailImpl = new PasteImpl(manager);
    }

    @Override
    public Paste createPaste(String name, String createdDate, String idUser) {
        return emailImpl.createPaste(name, createdDate, idUser);
    }

    @Override
    public boolean deletePaste(String idPaste) {
        return emailImpl.deletePaste(idPaste);
    }

    @Override
    public Paste updatePaste(Paste paste) {
        return emailImpl.updatePaste(paste);
    }

    @Override
    public Paste getPaste(String idPaste) {
        return emailImpl.getPaste(idPaste);
    }

    @Override
    public List<Paste> getAllPastesByUser(String idUser) {
        return emailImpl.getAllPastesByUser(idUser);
    }

    @Override
    public List<Email> getEmailsByPaste(String idPaste) {
        return emailImpl.getEmailsByPaste(idPaste);
    }
}
