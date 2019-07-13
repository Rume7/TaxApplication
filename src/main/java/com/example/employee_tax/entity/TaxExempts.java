package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 */
public class TaxExempts implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private double pension;
    private double gratuityPayment;
    private double lifeAssurance;
    private double NHF;             // National Housing Fund
    private double NHIS;            // National Health Insurance scheme

    public TaxExempts() {
    }

    public TaxExempts(double pension, double gratuityPayment, double lifeAssurance, double NHF, double NHIS) {
        this.pension = pension;
        this.gratuityPayment = gratuityPayment;
        this.lifeAssurance = lifeAssurance;
        this.NHF = NHF;
        this.NHIS = NHIS;
    }
    
    public double getPension() {
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }

    public double getGratuityPayment() {
        return gratuityPayment;
    }

    public void setGratuityPayment(double gratuityPayment) {
        this.gratuityPayment = gratuityPayment;
    }

    public double getLifeAssurance() {
        return lifeAssurance;
    }

    public void setLifeAssurance(double lifeAssurance) {
        this.lifeAssurance = lifeAssurance;
    }

    public double getNHF() {
        return NHF;
    }

    public void setNHF(double NHF) {
        this.NHF = NHF;
    }

    public double getNHIS() {
        return NHIS;
    }

    public void setNHIS(double NHIS) {
        this.NHIS = NHIS;
    }
    
    public double getTotalTaxExempts() {
        return this.getGratuityPayment() + this.getLifeAssurance() + 
                this.getNHF() + this.getNHIS() + this.getPension();
    }   

    @Override
    public String toString() {
        return "Tax Exempts = " + this.getTotalTaxExempts();
    }
}