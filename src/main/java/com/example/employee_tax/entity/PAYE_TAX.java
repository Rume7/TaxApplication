package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 */
public class PAYE_TAX implements Serializable {

    private static final long serialVersionUID = 1L;

    private double monthlyGrossIncome;
    private EmployeeTAX empTax;
    private static TaxTable taxTable = TaxTable.getInstanceOfTaxTable();
    private static Double[] taxes, rates, amounts;

    public PAYE_TAX(EmployeeTAX employeeIncome) {
        this.empTax = employeeIncome;
        this.monthlyGrossIncome = employeeIncome.getGrossTaxableIncome();
        rates = TaxTable.getRates();
        amounts = TaxTable.getAmounts();
        taxes = new Double[rates.length];
    }

    public double getMonthlyNetTaxableIncome() {
        return this.empTax.getNetTaxableIncome();
    }

    private void calculate_tax() {
        double amountLeft = getMonthlyNetTaxableIncome();
        
        for (int i = 0; i < rates.length; i++) {
            taxes[i] = (rates[i] * amounts[i]) / 100.0;
            amountLeft = amountLeft - amounts[i];
            if (amountLeft <= amounts[i]) {
                taxes[i] = (rates[i] * amountLeft ) / 100.0;
                break;
            }
        }
    }

    public double getPAYE_AMOUNT() {
        calculate_tax();
        double total = 0.0;
        for (Double tax : taxes) {
            total += tax;
        }
        return total;
    }
}
