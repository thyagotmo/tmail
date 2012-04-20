/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgt.email.spec.req;

import tmail.model.ont.User;

/**
 *
 * @author Thyago
 */
public interface ICadastroMgt {

    public User createUser(String idUser);

    public User updateUser(User user);

    public boolean deleteUser(String idUser);

    public User getUser(String idUser);
}
