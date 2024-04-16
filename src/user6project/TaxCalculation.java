/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user6project;

/**
 *
 * @author sumiya
 */
public class TaxCalculation {
    private double taxRate;
    private double grossRevenue;
    private double totalExpenses;
    private double taxableIncome;
    private double taxOwed;

    public TaxCalculation(double taxRate, double grossRevenue, double totalExpenses, double taxableIncome, double taxOwed) {
        this.taxRate = taxRate;
        this.grossRevenue = grossRevenue;
        this.totalExpenses = totalExpenses;
        this.taxableIncome = taxableIncome;
        this.taxOwed = taxOwed;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTaxOwed() {
        return taxOwed;
    }

    public void setTaxOwed(double taxOwed) {
        this.taxOwed = taxOwed;
    }

    @Override
    public String toString() {
        return "TaxCalculation{" + "taxRate=" + taxRate + ", grossRevenue=" + grossRevenue + ", totalExpenses=" + totalExpenses + ", taxableIncome=" + taxableIncome + ", taxOwed=" + taxOwed + '}';
    }
    
    
    
}
