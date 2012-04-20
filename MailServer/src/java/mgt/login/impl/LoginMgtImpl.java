package mgt.login.impl;

import mgt.login.spec.req.ICadastroMgt;
import tmail.model.ont.User;

/**
 * Classe LoginImpl
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
class LoginMgtImpl {

    //Declaração de variáveis
    private Manager manager;
    private ICadastroMgt iCadastroMgt;

    /**
     * Construtor da classe LoginMgtImpl
     *
     * @param manager - Manager do componente Login
     */
    protected LoginMgtImpl(Manager manager) {
        this.manager = manager;

    }

    /**
     * Metodo que retorna o password do usuário
     *
     * @param idUser - ID do usuário
     * @return Password do usuário
     */
    public String getPasswordByUser(String idUser) {
        iCadastroMgt = (ICadastroMgt) this.manager.getRequiredInterface("ICadastroMgt");

        User user = iCadastroMgt.getUser(idUser);

        String password;
        if (user == null) {
            password = null;
        } else {
            password = user.getPassword();

        }
        return password;
    }
}
