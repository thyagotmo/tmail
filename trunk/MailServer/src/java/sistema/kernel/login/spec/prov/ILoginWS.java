package sistema.kernel.login.spec.prov;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface ILoginWS
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
@WebService(name = "ILoginWS")
public interface ILoginWS {

    /**
     * Metodo que valida o login de um usuário no sistema
     *
     * @param idUser - ID do usuário a ser validado
     * @param password - Password do usuário
     * @return true se o usuário for validado com sucesso, false caso contrário
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "idUser") String idUser, @WebParam(name = "password") String password);
}
