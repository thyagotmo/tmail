package mgt.email.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mgt.email.spec.prov.IManager;

/**
 * Manager
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
public class Manager implements IManager {

    //Map com todas as interfaces requeridas
    private Map<String, Object> requiredInterfaces;
    //Map com todas as providas requeridas
    private Map<String, Object> providedInterfaces;
    //Boolean de controle do singleton
    private static boolean singletonControl = false;
    private static Manager MANAGER;

    /*
     * Construtor que adiciona no map todas as interfaces requeridas e providas
     * pelo componente
     */
    private Manager() {

        //Instânciar os maps de interfaces requiridas e providas
        requiredInterfaces = new HashMap<String, Object>();
        providedInterfaces = new HashMap<String, Object>();

        //Adicionar no map as interface requeridas
        requiredInterfaces.put("ICadastroMgt", null);

        //Adicionar no map as interface providas
        providedInterfaces.put("IEmailMgt", new FacadeIEmailMgt(this));
        providedInterfaces.put("IPasteMgt", new FacadeIPasteMgt(this));

    }

    /**
     * Retorna uma nova instância de manager
     *
     * @return Nova instância de manager
     */
    protected synchronized static Manager getManager() {
        if (!singletonControl) { //Caso não exista, criar uma nova
            singletonControl = true;
            MANAGER = new Manager();
        }
        return MANAGER;
    }

    /**
     * Dado o nome de uma interface provida, retorna um objeto que implementa
     * esta interface
     *
     * @param inter String - Nome da interface provida
     * @return Object - Objeto que implementa a interface solicitada
     */
    @Override
    public Object getProvidedInterface(String inter) {
        //Verifica se o map possui a interface solicitada
        if (providedInterfaces.containsKey(inter)) { //Caso positivo, retorna o objeto que implementa a interface
            return providedInterfaces.get(inter);
        } else { //Caso negativo, imprime uma messagem de erro e retorna null
            System.err.println("Interface " + inter + " not found");
            return null;
        }

    }

    /**
     * Dado o nome de uma interface requerida, retorna um objeto que implementa
     * esta interface
     *
     * @param inter String - Nome da interface requerida
     * @return Object - Objeto que implementa a interface solicitada
     */
    @Override
    public Object getRequiredInterface(String inter) {

        //Verifica se o map possui a interface solicitada
        if (requiredInterfaces.containsKey(inter)) { //Caso positivo, retorna o objeto que implementa a interface
            return requiredInterfaces.get(inter);
        } else { //Caso negativo, imprime uma messagem de erro e retorna null
            System.err.println("Interface " + inter + " not found");
            return null;
        }

    }

    /**
     * Metodo que seta um objeto para uma interface requerida
     *
     * @param inter String - Nome da interface requerida a ser setada
     * @param object Object - Objeto que implementa a interface requerida a ser
     * setada
     */
    @Override
    public void setRequiredInterface(String inter, Object object) {

        //Verifica se o map possui a chave com a interface solicitada
        if (this.requiredInterfaces.containsKey(inter)) { //Caso positivo, seta o objeto no map
            this.requiredInterfaces.put(inter, object);
        } else { //Caso negativo, imprime uma messagem de erro
            System.err.println("Interface " + inter + " not found");
        }
    }

    /**
     * Metodo que retorna uma lista com todas as interfaces requeridas
     *
     * @return List<String> - Lista contendo todos os nomes das interfaces
     * requeridas pelo componente
     */
    @Override
    public List<String> listRequiredInterfaces() {
        List<String> lista = new ArrayList<String>();
        lista.addAll(this.requiredInterfaces.keySet());

        return lista;
    }
}
