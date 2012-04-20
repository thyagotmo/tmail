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
public class EmailDTO implements Serializable {

    private String dateSent;
    private String id;
    private String message;
    private String subject;
    private UserDTO sentUser;
    private HashSet<UserDTO> receivedUser;
    
    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashSet<UserDTO> getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(HashSet<UserDTO> receivedUser) {
        this.receivedUser = receivedUser;
    }

    public UserDTO getSentUser() {
        return sentUser;
    }

    public void setSentUser(UserDTO sentUser) {
        this.sentUser = sentUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    }
