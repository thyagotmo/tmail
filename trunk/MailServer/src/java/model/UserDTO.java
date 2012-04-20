/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;

/**
 *
 * @author Thyago
 */
public class UserDTO implements Serializable {

    private String birthDay;
    private String firstName;
    private String lastName;
    private String gender;
    private String login;
    private String password;
    private HashSet<PasteDTO> pastes;

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<PasteDTO> getPastes() {
        return pastes;
    }

    public void setPastes(HashSet<PasteDTO> pastes) {
        this.pastes = pastes;
    }
}
