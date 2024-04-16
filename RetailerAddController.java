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
public class RetailerAddController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField userPasswordTextField;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private CheckBox retailerPermanentCheckbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         productComboBox.getItems().addAll("FRUIT TART", "MANGO SWEETS", "BROWNIES PASTRY", "PYRAMID PASTRY", "MOUSSE CUP", "MIX FOREST PASTRY","BELGIUM PASTRY","CHOCOLATE PASTRY","STRAWBERRY PASTRY","BLACK FOREST","GANACHE PASTRY","CREAM ROLL");
    }    

    @FXML
    private void confirmAddRetailerButtonOnClick(ActionEvent event) {
        long timestamp = System.currentTimeMillis();
        int retailerID = (int) (timestamp & 0xFFFFFFFF);
        
        String retailerName = userNameTextField.getText();
        String retailerPassword = userPasswordTextField.getText();
        String retailerType = productComboBox.getValue();
        LocalDate retailerDOJ = dojDatePicker.getValue();
        boolean retailerPermanent = false;

        if (retailerPermanentCheckbox.isSelected()) {
            boolean retailerFullTime = true;
        }
        
        if ("".equals(retailerName) | "".equals(retailerPassword) | "".equals(retailerType)) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Registration Unsuccessful");
            a.setContentText("Please check entered details");
            a.showAndWait();
        }
        else {
            Retailer newRetailer = new Retailer(retailerName, retailerPassword, retailerType, retailerDOJ);

            Retailer.WriteRetailerToRetailerFile(newRetailer);
            Retailer.WriteRetailerToLoginFile(newRetailer);
            
        }
    }    

}

