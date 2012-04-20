/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.cadastro.impl;

import javax.jws.WebService;
import model.UserDTO;
import sistema.kernel.cadastro.spec.prov.ICadastroWS;

/**
 *
 * @author Thyago
 */
@WebService(endpointInterface = "sistema.kernel.cadastro.spec.prov.ICadastroWS")
class FacadeICadastroWS implements ICadastroWS {

    private CadastroWSImpl cadastroWSImpl;

    public FacadeICadastroWS() {
        Manager manager = Manager.getManager();
        this.cadastroWSImpl = new CadastroWSImpl(manager);
    }

    @Override
    public boolean registerUser(String firstName, String lastName, String birthDay, String gender, String login, String password) {
        return cadastroWSImpl.registerUser(firstName, lastName, birthDay, gender, login, password);
    }

    @Override
    public boolean updateUserInformation(String login, String newFirstName, String newLastName, String newBirthDay, String newGender) {
        return cadastroWSImpl.updateUserInformation(login, newFirstName, newLastName, newBirthDay, newGender);
    }

    @Override
    public boolean changePassword(String login, String newPassword) {
        return cadastroWSImpl.changePassword(login, newPassword);
    }

    @Override
    public boolean deleteUser(String idUser) {
        return cadastroWSImpl.deleteUser(idUser);
    }

    @Override
    public UserDTO getUser(String idUser) {
        return cadastroWSImpl.getUser(idUser);
    }
}
