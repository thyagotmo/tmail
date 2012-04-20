package sistema.kernel.cadastro.impl;


import sistema.kernel.cadastro.spec.prov.ICadastro;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
class FacadeICadastro implements ICadastro {

    private CadastroImpl cadastroImpl;

    protected FacadeICadastro(Manager manager) {
        this.cadastroImpl = new CadastroImpl(manager);
    }

    @Override
    public User registerUser(String firstName, String lastName, String birthDay, String gender, String login, String password) {
        return cadastroImpl.registerUser(firstName, lastName, birthDay, gender, login, password);
    }

    @Override
    public boolean updateUserInformation(String login, String newFirstName, String newLastName, String newBirthDay, String newGender) {
        return cadastroImpl.updateUserInformation(login, newFirstName, newLastName, newBirthDay, newGender);
    }

    @Override
    public boolean changePassword(String login, String newPassword) {
        return cadastroImpl.changePassword(login, newPassword);
    }

    @Override
    public boolean deleteUser(String idUser) {
        return cadastroImpl.deleteUser(idUser);
    }

    @Override
    public User getUser(String idUser) {
        return cadastroImpl.getUser(idUser);
    }
}
