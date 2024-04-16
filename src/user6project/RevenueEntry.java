/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user6project;

/**
 *
 * @author sumiya
 */

import java.time.LocalDate;

public class RevenueEntry {
    private LocalDate date;
    private String description;
    private double projectedRevenue;
    private double totalRevenue;

    public RevenueEntry(LocalDate date, String description, double projectedRevenue) {
        this.date = date;
        this.description = description;
        this.projectedRevenue = projectedRevenue;
        this.totalRevenue = 0;
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

    public double getProjectedRevenue() {
        return projectedRevenue;
    }

    public void setProjectedRevenue(double projectedRevenue) {
        this.projectedRevenue = projectedRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
    

