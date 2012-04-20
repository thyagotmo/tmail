package mgt.login.spec.prov;

import java.util.List;

/**
 * Interface IManager
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
public interface IManager {

    /**
     * Este Metodo retorna uma das interfaces providas pelo componente
     *
     * @param inter - String representando a interface solicitada
     * @return Objeto que implementa a interface solicitada
     */
    public Object getProvidedInterface(String inter);

    /**
     * Este Metodo retorna uma das interfaces requeridas pelo componente
     *
     * @param inter - String representando a interface solicitada
     * @return Objeto que implementa a interface solicitada
     */
    public Object getRequiredInterface(String inter);

    /**
     * Este metodo retorna todas as string que representam as interfaces
     * requeridas pelo componente
     *
     * @return Lista contendo as interface requeridas
     */
    public List<String> listRequiredInterfaces();

    /**
     * Este metodo seta uma interface requerida pelo componente
     *
     * @param inter - String que representa a interface
     * @param Object class - Objeto que implementa a interface
     */
    public void setRequiredInterface(String inter, Object classe);
}