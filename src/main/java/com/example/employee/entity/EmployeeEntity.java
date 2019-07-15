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
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="Middle Name")
    private String middleName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    @Column(name="OFFICIAL_EMAIL")
    private String employeeEmail;
    
    @Column(name="MONTHLY_GROSS_PAY")
    private Double monthlyWage;
    
    @Column(name="MARITAL_STATUS")
    private String maritalStatus;
    
    @Column(name="TIN")
    private String TIN;
    
    @Column(name="COMPANY")
    private String company;
    
    @Column(name="DEPT")
    private String department;
    
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.employeeID);
        hash = 89 * hash + Objects.hashCode(this.TIN);
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
        if (!Objects.equals(this.TIN, other.TIN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee[ id=" + employeeID + " ]";
    }
}
