/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mrbaker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EmployeeAddController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField userPasswordTextField;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private ComboBox<String> userDesignationComboBox;
    @FXML
    private TextField employeeSalaryTextField;
    @FXML
    private CheckBox employeeFullTimeCheckbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userDesignationComboBox.getItems().addAll("System Administrator", "Shop Clerk", "Regulatory Officer", "CEO", "CFO", "HR","Retailer");
            
    }    

    @FXML
    private void confirmAddEmployeeButtonOnClick(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int employeeID = (int) (timestamp & 0xFFFFFFFF);
        
        String employeeName = userNameTextField.getText();
        String employeePassword = userPasswordTextField.getText();
        String employeeType = userDesignationComboBox.getValue();
        double employeeSalary = Double.parseDouble(employeeSalaryTextField.getText());
        LocalDate employeeDOJ = dojDatePicker.getValue();
        boolean employeeFullTime = false;

        if (employeeFullTimeCheckbox.isSelected()) {
            employeeFullTime = true;
        }
        
        if ("".equals(employeeName) | "".equals(employeeType) | "".equals(employeePassword) | employeeSalary == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Registration Unsuccessful");
            a.setContentText("Please check entered details");
            a.showAndWait();
        }
        else {
            Employee newEmployee = new Employee(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);

            Employee.WriteEmployeeToEmployeeFile(newEmployee);
            Employee.WriteEmployeeToLoginFile(newEmployee);
            
        }
    }    

}

