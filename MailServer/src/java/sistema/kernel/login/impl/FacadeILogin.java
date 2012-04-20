package sistema.kernel.login.impl;

import sistema.kernel.login.spec.prov.ILogin;

/**
 * Classe FacadeILogin - responsável pela implementação dos metodos da interface
 * ILogin
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
class FacadeILogin implements ILogin {

    //Declaração de variáveis
    private LoginImpl loginImpl;

    /**
     * Construtor da classe FacadeILogin
     *
     * @param manager - Manager do componente Login
     *
     */
    protected FacadeILogin(Manager manager) {
        this.loginImpl = new LoginImpl(manager);
    }

    /**
     * Metodo que valida o login de um usuário no sistema
     *
     * @param idUser - ID do usuário a ser validado
     * @param password - Password do usuário
     * @return true se o usuário for validado com sucesso, false caso contrário
     */
    @Override
    public boolean login(String idUser, String password) {
        return loginImpl.validateLogin(idUser, password);
    }
}
