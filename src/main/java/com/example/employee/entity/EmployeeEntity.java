package com.example.employee.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author E238958
 */
@Entity(name="Employee")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Employee_ID")
    private String employeeID;
    
    @Column(name="SOCIAL_SECURITY_NUMBER")
    private String SSN;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    @Column(name="Official_Email")
    private String employeeEmail;
    
    @Column(name="MONTHLY_GROSS_PAY")
    private Double monthlyWage;
    
    @Column(name="MARITAL_STATUS")
    private String maritalStatus;
    
    @Column(name="AGE_IN_YEARS")
    private Integer age;
    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Double getMonthlyWage() {
        return monthlyWage;
    }

    public void setMonthlyWage(Double monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.employeeID);
        hash = 89 * hash + Objects.hashCode(this.SSN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeEntity other = (EmployeeEntity) obj;
        if (!Objects.equals(this.employeeID, other.employeeID)) {
            return false;
        }
        if (!Objects.equals(this.SSN, other.SSN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee[ id=" + employeeID + " ]";
    }
}
