package sistema.kernel.cadastro.spec.prov;

import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public interface ICadastro {

    public User registerUser(String firstName, String lastName, String birthDay, String gender,
            String login, String password);

    public boolean updateUserInformation(String login, String newFirstName, String newLastName, String newBirthDay, String newGender);

    public boolean changePassword(String login, String newPassword);

    public boolean deleteUser(String idUser);

    public User getUser(String idUser);
}
