package sistema.kernel.login.impl;

import javax.jws.WebService;
import sistema.kernel.login.spec.prov.ILoginWS;

/**
 * Classe FacadeILoginWS - responsável pela implementação dos serviços da
 * interface ILoginWS
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
@WebService(endpointInterface = "sistema.kernel.login.spec.prov.ILoginWS")
public class FacadeILoginWS implements ILoginWS {

    //Declaração de variáveis
    private Manager manager;
    private LoginWSImpl loginWSImpl;

    //Construtor da classe FacadeILoginWS
    public FacadeILoginWS() {
        this.manager = Manager.getManager();
        loginWSImpl = new LoginWSImpl(manager);
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
        return loginWSImpl.validateLogin(idUser, password);
    }
    
}
