package sistema.kernel.login.spec.prov;

/**
 * Interface ILogin
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
public interface ILogin {

    /**
     * Metodo que valida o login de um usuário no sistema
     *
     * @param idUser - ID do usuário a ser validado
     * @param password - Password do usuário
     * @return true se o usuário for validado com sucesso, false caso contrário
     */
    public boolean login(String idUser, String password);
}
