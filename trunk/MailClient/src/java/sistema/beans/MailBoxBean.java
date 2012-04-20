/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import sistema.wscomunicator.EmailComunicator;
import sistema.wscomunicator.iemail.EmailDTO;
import sistema.wscomunicator.iemail.IEmailWS;
import sistema.wscomunicator.iemail.PasteDTO;

/**
 *
 * @author Thyago
 */
public class MailBoxBean implements Serializable {

    private TreeNode rootTree;
    private TreeNode selectedNode;
    private List<EmailDTO> mails;
    private EmailDTO selectedMail;

    public MailBoxBean() {
        mails = new ArrayList<EmailDTO>();
        rootTree = new DefaultTreeNode("root", null);



        this.loadPastes();
        this.loadEmails();


    }

    public List<EmailDTO> getMails() {
        return mails;
    }

    public void setMails(List<EmailDTO> mails) {
        this.mails = mails;
    }

    public EmailDTO getSelectedMail() {
        return selectedMail;
    }

    public void setSelectedMail(EmailDTO selectedMail) {
        this.selectedMail = selectedMail;
    }

    public TreeNode getRootTree() {
        return rootTree;
    }

    public void setRootTree(TreeNode rootTree) {
        this.rootTree = rootTree;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    private void loadPastes() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String idUser = (String) session.getAttribute("idUser");

        EmailComunicator emailComunicator = EmailComunicator.getInstance();
        IEmailWS emailImpl = emailComunicator.getEmailImpl();

        List<PasteDTO> pastes = emailImpl.getAllPastesByUser(idUser);


        for (PasteDTO paste : pastes) {
            new DefaultTreeNode("past", paste.getName(), rootTree);

        }

    }

    private void loadEmails() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String idUser = (String) session.getAttribute("idUser");

        EmailComunicator emailComunicator = EmailComunicator.getInstance();
        IEmailWS emailImpl = emailComunicator.getEmailImpl();

        mails = emailImpl.getReceivedEmailsByUser(idUser);

    }

    public void onNodeSelect() {
    }

    public void deleteEmail() {
        this.mails.remove(this.selectedMail);

    }
}
