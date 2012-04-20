package mgt.login.impl;

import mgt.login.spec.prov.ILoginMgt;

/**
 * Classe FacadeILoginMgt - responsável pela implementação dos metodos da
 * interface ILoginMgt
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
class FacadeILoginMgt implements ILoginMgt, sistema.kernel.login.spec.req.ILoginMgt {

    //Declaração de variáveis
    private LoginMgtImpl loginMgtImpl;

    /**
     * Construtor da classe FacadeILogin
     *
     * @param manager - Manager do componente Login
     *
     */
    protected FacadeILoginMgt(Manager manager) {
        this.loginMgtImpl = new LoginMgtImpl(manager);
    }

    /**
     * Metodo que retorna o password do usuário
     *
     * @param idUser - ID do usuário
     * @return Password do usuário
     */
    @Override
    public String getPasswordByUser(String idUser) {
        return this.loginMgtImpl.getPasswordByUser(idUser);
    }
}
