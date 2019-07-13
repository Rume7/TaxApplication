package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 * This calculates the monthly Gross 
 */
public class GrossTaxableIncome implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private double basicSalary;
    private double housing;
    private double transport;
    private Allowances allowances;
    private double outstation;

    public GrossTaxableIncome() {
        this.allowances = new Allowances();
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHousing() {
        return housing;
    }

    public void setHousing(double housing) {
        this.housing = housing;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public Allowances getAllowances() {
        return allowances;
    }

    public void setAllowances(Allowances allowances) {
        this.allowances = allowances;
    }

    public double getOutstation() {
        return outstation;
    }

    public void setOutstation(double outstation) {
        this.outstation = outstation;
    }
    
    public double getGrossIncome() {
        return this.getBasicSalary() + this.getHousing() + this.getTransport() + 
                this.getOutstation() + this.getAllowances().getSumOfAllowances();
    }

    @Override
    public String toString() {
        return "Monthly Gross Income  = " + '}';
    }
}
