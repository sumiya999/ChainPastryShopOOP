/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOtaxPlanningController implements Initializable {

    @FXML
    private TableView<TaxCalculation> taxCalculationTV;
    @FXML
    private TableColumn<TaxCalculation, Double> taxRateCol;
    @FXML
    private TableColumn<TaxCalculation, Double> grossRevenueCol;
    @FXML
    private TableColumn<TaxCalculation, Double> totalExpensesCol;
    @FXML
    private TableColumn<TaxCalculation, Double> taxableIncomeCol;
    @FXML
    private TableColumn<TaxCalculation, Double> taxOwedCol;
    @FXML
    private TableView<NetIncomeAfterTax> netIncomeAfterTaxTV;
    @FXML
    private TableColumn<NetIncomeAfterTax, Double> netIncomeCol;
    @FXML
    private TableView<TotalExpenses> totalExpensesTV;
    @FXML
    private TableColumn<TotalExpenses, String> businessExpensesCol;
    @FXML
    private TableColumn<TotalExpenses, Double> amountCol;

    private ObservableList<TaxCalculation> taxCalculationList;
    private ObservableList<TotalExpenses> expensesData;

    @FXML
    private TextField businessExpenseTF;
    @FXML
    private TextField amountTF;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taxRateCol.setCellValueFactory(new PropertyValueFactory<>("taxRate"));
        grossRevenueCol.setCellValueFactory(new PropertyValueFactory<>("grossRevenue"));
        totalExpensesCol.setCellValueFactory(new PropertyValueFactory<>("totalExpenses"));
        taxableIncomeCol.setCellValueFactory(new PropertyValueFactory<>("taxableIncome"));
        taxOwedCol.setCellValueFactory(new PropertyValueFactory<>("taxOwed"));

        taxCalculationTV.setItems(taxCalculationList);
        taxCalculationTV.setItems(getTaxCalculationData());
        
        netIncomeCol.setCellValueFactory(new PropertyValueFactory<>("netIncome"));
        netIncomeAfterTaxTV.setItems(getNetIncomeAfterTaxData());
        
        businessExpensesCol.setCellValueFactory(new PropertyValueFactory<TotalExpenses,String>("businessExpenses"));
        amountCol.setCellValueFactory(new PropertyValueFactory<TotalExpenses,Double>("amount"));
        totalExpensesTV.setItems(expensesData);
    }    

    @FXML
    private void generateTaxReportButton(ActionEvent event) {
    }

    @FXML
    private void backToHomeButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("CFOdashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    private ObservableList<NetIncomeAfterTax> getNetIncomeAfterTaxData() {
        return FXCollections.observableArrayList(); 
    }

    private ObservableList<TotalExpenses> getTotalExpensesData() {
        return expensesData;
    }

    
    private double calculateTotalExpenses() {
        double total = 0;
        for (TotalExpenses expense : expensesData) {
            total += expense.getAmount();
        }
        return total;
    }
    

    private ObservableList<TaxCalculation> getTaxCalculationData() {
        return FXCollections.observableArrayList(); 
    }

    @FXML
    private void addExpenseButton(ActionEvent event) {
        TotalExpenses newExpense = new TotalExpenses(businessExpenseTF.getText(), Double.parseDouble(amountTF.getText()));
        expensesData.add(newExpense);
    }
    
}
