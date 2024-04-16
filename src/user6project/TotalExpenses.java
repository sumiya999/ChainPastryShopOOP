/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user6project;

/**
 *
 * @author sumiya
 */
public class TotalExpenses {
    private final String businessExpenses;
    private final double amount;

    public TotalExpenses(String businessExpenses, double amount) {
        this.businessExpenses = businessExpenses;
        this.amount = amount;
    }

    public String getBusinessExpenses() {
        return businessExpenses;
    }


    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TotalExpenses{" + "businessExpenses=" + businessExpenses + ", amount=" + amount + '}';
    }
    
    
    

}
