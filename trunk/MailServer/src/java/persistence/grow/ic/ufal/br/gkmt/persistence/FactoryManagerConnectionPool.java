/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.grow.ic.ufal.br.gkmt.persistence;

/**
 *
 * @author endhe
 */
public final class FactoryManagerConnectionPool {

    public static synchronized ManagerConnectionPool getManagerConnectionPool() {
        return GKMTManagerConnectionPool.getManagerConnectionPool();
    }
}
