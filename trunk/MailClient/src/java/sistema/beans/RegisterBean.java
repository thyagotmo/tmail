/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sistema.wscomunicator.CadastroComunicator;
import sistema.wscomunicator.icadastro.ICadastroWS;
import sistema.wscomunicator.icadastro.UserDTO;

/**
 *
 * @author Thyago
 */
public class RegisterBean implements Serializable {

    private UserDTO user;

    public RegisterBean() {
        user = new UserDTO();
    }

    public String registerUser() {

        CadastroComunicator cadastroComunicator = CadastroComunicator.getInstance();
        ICadastroWS cadastroImpl = cadastroComunicator.getCadastroImpl();
        boolean result = cadastroImpl.registerUser(user.getFirstName(), user.getLastName(),
                user.getBirthDay(), user.getGender(), user.getLogin(), user.getPassword());

        if (result) {
            return "sucessRegister";
        } else {
            FacesMessage msg = new FacesMessage("Não foi possivel realizar o cadastro!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return null;
        }

    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
