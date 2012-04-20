package sistema.kernel.login.spec.req;

/**
 * Interface ILoginMgt
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
public interface ILoginMgt {

    /**
     * Metodo que retorna o password do usuário
     *
     * @param idUser - ID do usuário
     * @return Password do usuário
     */
    public String getPasswordByUser(String idUser);
}
