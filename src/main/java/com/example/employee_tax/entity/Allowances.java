package com.example.employee_tax.entity;

import java.io.Serializable;

/**
 *
 * @author E238958
 */
public class Allowances implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private double utilityAllowance;
    private double leaveAllowance;
    private double fieldAllowance;

    public Allowances() {
        this(0, 0, 0);
    }

    public Allowances(double utility, double leave, double field) {
        this.utilityAllowance = utility;
        this.leaveAllowance = leave;
        this.fieldAllowance = field;
    }

    public double getUtilityAllowance() {
        return utilityAllowance;
    }

    public void setUtilityAllowance(double utilityAllowance) {
        this.utilityAllowance = utilityAllowance;
    }

    public double getLeaveAllowance() {
        return leaveAllowance;
    }

    public void setLeaveAllowance(double leaveAllowance) {
        this.leaveAllowance = leaveAllowance;
    }

    public double getFieldAllowance() {
        return fieldAllowance;
    }

    public void setFieldAllowance(double fieldAllowance) {
        this.fieldAllowance = fieldAllowance;
    }

    public double getSumOfAllowances() {
        double total = this.getFieldAllowance() + this.getLeaveAllowance() + 
                this.getUtilityAllowance();
        return total;
    }
    
    @Override
    public String toString() {
        return "Allowances{" + '}';
    }
}
