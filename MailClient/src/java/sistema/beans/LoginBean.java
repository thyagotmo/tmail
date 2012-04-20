/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sistema.wscomunicator.LoginComunicator;
import sistema.wscomunicator.icadastro.UserDTO;
import sistema.wscomunicator.ilogin.ILoginWS;

/**
 *
 * @author Thyago
 */
public class LoginBean implements Serializable {

    private UserDTO user;

    public LoginBean() {
        user = new UserDTO();
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String efetuarLogin() {

        //Criando o comunicador e fazendo a chamada do serviço
        LoginComunicator comunicator = LoginComunicator.getInstance();
        ILoginWS loginIMpl = comunicator.getLoginImpl();
        boolean validateLogin = loginIMpl.login(user.getLogin(), user.getPassword());

        System.out.println("Passou");
        if (validateLogin) {

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("idUser", user.getLogin());

            return "loginSuccess";
        } else {
            FacesMessage msg = new FacesMessage("Usuário ou senha inválidos!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return null;
        }
    }
}
