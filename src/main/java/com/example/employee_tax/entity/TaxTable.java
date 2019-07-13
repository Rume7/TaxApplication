package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 * Make it a singleton
 */
public class TaxTable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static TaxTable taxTable;
    private static GrossTaxableIncome grossTaxablePay;
    private static Double[] amount = new Double[]{25000.0, 25000.0, 41666.0, 41666.0, 133333.0, 266666.0};;
    private static Double[] rates = new Double[]{7.0, 11.0, 15.0, 19.0, 21.0, 24.0} ;
    

    private TaxTable() {
    }
    
    public static TaxTable getInstanceOfTaxTable() {
        if (taxTable != null) {
            taxTable = new TaxTable();
        }
        return taxTable;
    }
    
    public static Double[] getAmounts() {
        return amount;
    }
    
    public static Double[] getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "TaxTable{" + '}';
    }
}
