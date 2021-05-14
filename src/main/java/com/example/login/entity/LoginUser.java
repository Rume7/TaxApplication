package com.example.login.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Rhume
 */
@Entity(name = "Login_User")
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="Email_Address")
    private String emailAddress;
    
    @Column(name="Password")
    private String password;

    public LoginUser() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login = " + this.getEmailAddress();
    }
}
