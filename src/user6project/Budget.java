
package user6project;

import java.io.Serializable;

/**
 *
 * @author sumiya
 */
public class Budget implements Serializable{
    private String Task;
    private String Month;
    private int Year;
    private int Budget;

    public Budget(String Task, String Month, int Year, int Budget) {
        this.Task = Task;
        this.Month = Month;
        this.Year = Year;
        this.Budget = Budget;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int Budget) {
        this.Budget = Budget;
    }

    @Override
    public String toString() {
        return "Budget{" + "Task=" + Task + ", Month=" + Month + ", Year=" + Year + ", Budget=" + Budget + '}';
    }
    
    
    



    
    
}
