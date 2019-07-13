package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 */
public class TaxableAllowance implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private double consolidatedRelief;
    private double PGI;
    private GrossTaxableIncome grossTaxableIncome;
    private final double CONSOLIDATION_RELIEF_BENCHMARK = 200000;

    public TaxableAllowance(GrossTaxableIncome grossTaxableIncome) {
        this.grossTaxableIncome = grossTaxableIncome;
    }
    
    public double getConsolidatedRelief() {
        int monthsInAYear = 12;
        double annualGross = this.getGrossTaxableIncome() * monthsInAYear;
        
        double relief = 0.01 * annualGross;         // Relief is 1% of Annual Gross Income
        
        if (relief > CONSOLIDATION_RELIEF_BENCHMARK) {
            this.consolidatedRelief = relief / monthsInAYear;
        } else {
            this.consolidatedRelief = CONSOLIDATION_RELIEF_BENCHMARK/ monthsInAYear;
        }
        return consolidatedRelief;
    }

    // Percentage of Gross Income Relief, PGI is 20% of Annual Gross Income
    public double getPGI() {
        this.PGI = 0.20 * this.getGrossTaxableIncome();
        return PGI;
    }
    
    public double getGrossTaxableIncome() {
        return grossTaxableIncome.getGrossIncome();
    }
    
    public double getSumOfTaxableAllowances() {
        return this.getConsolidatedRelief() + this.getPGI();
    }   
}
