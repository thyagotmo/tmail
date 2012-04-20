package sistema.kernel.login.impl;

import sistema.kernel.login.spec.req.ILoginMgt;

/**
 * Classe LoginImpl
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
class LoginImpl {

    //Declaração de variáveis
    private Manager manager;

    /**
     * Construtor da classe LoginImpl
     *
     * @param manager - Manager do componente Login
     */
    protected LoginImpl(Manager manager) {
        this.manager = manager;

    }

    /**
     * Metodo que valida o login de um usuário no sistema
     *
     * @param idUser - ID do usuário a ser validado
     * @param password - Password do usuário
     * @return true se o usuário for validado com sucesso, false caso contrário
     */
    public boolean validateLogin(String idUser, String password) {

        ILoginMgt ILoginMgtImpl = (ILoginMgt) manager.getRequiredInterface("ILoginMgt");
        String passwordBase = ILoginMgtImpl.getPasswordByUser(idUser);

        //Verificar se o passwordBase
        if (passwordBase == null || password == null) {
            return false;
        } else if (passwordBase.equals(password)) {
            //Caso sejam iguais
            return true;
        } else {
            //Caso sejam diferentes
            return false;
        }

    }
    
}
