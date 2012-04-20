/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.email.spec.req;

import java.util.List;
import tmail.model.ont.Email;
import tmail.model.ont.Paste;

/**
 *
 * @author Thyago
 */
public interface IPasteMgt {

    public Paste createPaste(String idPaste);

    public boolean deletePaste(String idPaste);

    public Paste updatePaste(Paste paste);

    public Paste getPaste(String idPaste);

    public List<Paste> getAllPastesByUser(String idUser);

    public List<Email> getEmailsByPaste(String idPaste);
}
