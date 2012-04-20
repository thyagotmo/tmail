/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.kernel.cadastro.impl;

import model.UserDTO;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class CadastroWSImpl {

    private CadastroImpl cadastroImpl;

    protected CadastroWSImpl(Manager manager) {
        cadastroImpl = new CadastroImpl(manager);

    }

    public boolean registerUser(String firstName, String lastName, String birthDay, String gender, String login, String password) {
        User user = cadastroImpl.registerUser(firstName, lastName, birthDay, gender, login, password);

        if (user == null) {
            return false;
        } else {
            return true;
        }

    }

    public boolean updateUserInformation(String login, String newFirstName, String newLastName, String newBirthDay, String newGender) {
        return cadastroImpl.updateUserInformation(login, newFirstName, newLastName, newBirthDay, newGender);
    }

    public boolean changePassword(String login, String newPassword) {
        return cadastroImpl.changePassword(login, newPassword);
    }

    public boolean deleteUser(String idUser) {
        return cadastroImpl.deleteUser(idUser);
    }

    public UserDTO getUser(String idUser) {
        User user = cadastroImpl.getUser(idUser);
        UserDTO userDTO = model.ConvertForDTO.convertUserFotDTO(user);

        return userDTO;
    }
}
