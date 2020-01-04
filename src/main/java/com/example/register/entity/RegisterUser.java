package com.example.register.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author E238958
 */
@Entity(name = "Registered_User")
public class RegisterUser implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="EMAIL_ADDRESS")
    private String email;
    
    @Column(name="EmployeeID")
    private String employeeID;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="MIDDLE_NAME")
    private String middleName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    private String password;
    private String phoneNumber;
    private String company;

    public RegisterUser() {
    }
 
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    @Override
    public String toString() {
        return "Registration = " + this.getEmail();
    }
}
