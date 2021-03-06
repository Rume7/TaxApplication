package com.example.employee.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Rhume
 */
@Entity(name="Employee")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="EmployeeID")
    private String employeeID;
    
    @Column(name="EMAIL_ADDRESS")
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

    public EmployeeEntity() {
    }
    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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
        return Objects.equals(this.TIN, other.TIN);
    }

    @Override
    public String toString() {
        return "Employee id = " + employeeID;
    }
}
