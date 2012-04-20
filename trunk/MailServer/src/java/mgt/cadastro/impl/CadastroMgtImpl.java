/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgt.cadastro.impl;

import persistence.kao.OntologyKAO;
import persistence.utils.URIConstantes;
import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public class CadastroMgtImpl {

    public User createUser(String idUser) {
        OntologyKAO kao = new OntologyKAO(User.class);
        User user = kao.create(URIConstantes.TMAIL, idUser);

        return user;

    }

    public User updateUser(User user) {
        OntologyKAO kao = new OntologyKAO(User.class);
        user = kao.update(user);

        return user;
    }

    public boolean deleteUser(String idUser) {

        try {
            OntologyKAO kao = new OntologyKAO(User.class);
            kao.delete(URIConstantes.TMAIL, idUser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public User getUser(String idUser) {

        OntologyKAO kao = new OntologyKAO(User.class);
        User user = kao.retrieveInstance(URIConstantes.TMAIL, idUser);

        return user;

    }
}
