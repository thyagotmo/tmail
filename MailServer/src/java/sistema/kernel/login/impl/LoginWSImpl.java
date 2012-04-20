package sistema.kernel.login.impl;

/**
 * Classe LoginImpl
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
class LoginWSImpl {

    //Declaração de variáveis
    private LoginImpl loginImpl;

    /**
     * Construtor da classe LoginWSImpl
     *
     * @param manager - Manager do componente Login
     */
    protected LoginWSImpl(Manager manager) {
        loginImpl = new LoginImpl(manager);

    }

    /**
     * Metodo que valida o login de um usuário no sistema
     *
     * @param idUser - ID do usuário a ser validado
     * @param password - Password do usuário
     * @return true se o usuário for validado com sucesso, false caso contrário
     */
    public boolean validateLogin(String idUser, String password) {
        return loginImpl.validateLogin(idUser, password);

    }
}
