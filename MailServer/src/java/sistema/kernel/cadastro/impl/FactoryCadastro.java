package sistema.kernel.cadastro.impl;

import sistema.kernel.cadastro.spec.prov.IManager;

/**
 * Factory
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
public class FactoryCadastro {

    /**
     * Metodo que retorna um manager para configuração do componente
     *
     * @return IManager - Objeto que implementa a interface IManager
     */
    public synchronized static IManager getManager() {

        //Retorna a instância solicitada
        return Manager.getManager();
    }
}