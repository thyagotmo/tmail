package sistema.kernel.cadastro.spec.prov;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.UserDTO;

/**
 *
 * @author Thyago
 */
@WebService(name = "ICadastroWS")
public interface ICadastroWS {

    @WebMethod(operationName = "registerUser")
    public boolean registerUser(@WebParam(name = "firstName") String firstName,
            @WebParam(name = "lastName") String lastName,
            @WebParam(name = "birthDay") String birthDay,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "login") String login,
            @WebParam(name = "password") String password);

    @WebMethod(operationName = "updateUser")
    public boolean updateUserInformation(@WebParam(name = "login") String login,
            @WebParam(name = "firstName") String newFirstName,
            @WebParam(name = "lastName") String newLastName,
            @WebParam(name = "birthDay") String newBirthDay,
            @WebParam(name = "gender") String newGender);

    @WebMethod(operationName = "changePassword")
    public boolean changePassword(@WebParam(name = "login") String login,
            @WebParam(name = "password") String newPassword);

    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name = "idUser") String idUser);

    @WebMethod(operationName = "getUser")
    public UserDTO getUser(@WebParam(name = "idUser") String idUser);
}
