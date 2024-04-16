/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user6project;

import java.time.LocalDate;

/**
 *
 * @author sumiya
 */
public class CashflowEntry {
    private LocalDate date;
    private String description;
    private double cashInflows;
    private double cashOutflows;
    private double netCashflow;

    public CashflowEntry(LocalDate date, String description, double cashInflows, double cashOutflows, double netCashflow) {
        this.date = date;
        this.description = description;
        this.cashInflows = cashInflows;
        this.cashOutflows = cashOutflows;
        this.netCashflow = netCashflow;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCashInflows() {
        return cashInflows;
    }

    public void setCashInflows(double cashInflows) {
        this.cashInflows = cashInflows;
    }

    public double getCashOutflows() {
        return cashOutflows;
    }

    public void setCashOutflows(double cashOutflows) {
        this.cashOutflows = cashOutflows;
    }

    public double getNetCashflow() {
        return netCashflow;
    }

    public void setNetCashflow(double netCashflow) {
        this.netCashflow = netCashflow;
    }
}

