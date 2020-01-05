package com.example.employee_tax.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author E238958
 */
@Entity(name="Employee_Tax")
public class EmployeeTAX implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="EmployeeID")
    private String employeeID;
    
    @Column(name="MONTHLY_GROSS_INCOME")
    private Double grossTaxableIncome;
    
    @Column(name="TAX_EXEMPTS")
    private Double taxExempts;
   
    @Column(name="TAX_ALLOWANCES")
    private Double taxableAllowance;

    public EmployeeTAX() {
    }

    public EmployeeTAX(String employeeID) {
        this.employeeID = employeeID;
    }    

    public EmployeeTAX(String employeeID, GrossTaxableIncome grossTaxableIncome, TaxExempts taxExempts, TaxableAllowance taxableAllowance) {
        this.employeeID = employeeID;
        this.grossTaxableIncome = grossTaxableIncome.getGrossIncome();
        this.taxExempts = taxExempts.getTotalTaxExempts();
        this.taxableAllowance = taxableAllowance.getSumOfTaxableAllowances();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    public Double getGrossTaxableIncome() {
        return grossTaxableIncome;
    }

    public void setGrossTaxableIncome(GrossTaxableIncome grossTaxableIncome) {
        this.grossTaxableIncome = grossTaxableIncome.getGrossIncome();
    }

    public Double getTaxExempts() {
        return taxExempts;
    }

    public void setTaxExempts(TaxExempts taxExempts) {
        this.taxExempts = taxExempts.getTotalTaxExempts();
    }

    public Double getTaxableAllowance() {
        return taxableAllowance;
    }

    public void setTaxableAllowance(TaxableAllowance taxableAllowance) {
        this.taxableAllowance = taxableAllowance.getSumOfTaxableAllowances();
    }
    
    public double getNetTaxableIncome() {
        return this.grossTaxableIncome - this.getTaxExempts() - this.getTaxableAllowance();
    }

    @Override
    public String toString() {
        return "Employee Net Taxable Income  = " + this.getNetTaxableIncome();
    }
}
