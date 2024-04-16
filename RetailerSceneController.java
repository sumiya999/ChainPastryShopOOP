/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mrbaker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RetailerSceneController implements Initializable {

    @FXML
    private TableView<Retailer> retailerTableView;
    @FXML
    private TableColumn<Retailer, Integer> retailerIdColumn;
    @FXML
    private TableColumn<Retailer, String> retailerNameColumn;
    @FXML
    private TableColumn<Retailer, String> productTypeColumn;
    @FXML
    private TableColumn<Retailer, Boolean> retailerPermanentColumn;
    @FXML
    private TableColumn<Retailer, LocalDate> retailerDOJColumn;
    @FXML
    private TableColumn<Retailer, String> retailerPasswordColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        retailerIdColumn.setCellValueFactory(new PropertyValueFactory<Retailer,Integer>("retailerId"));
        retailerNameColumn.setCellValueFactory(new PropertyValueFactory<Retailer,String>("retailerName"));
        retailerPasswordColumn.setCellValueFactory(new PropertyValueFactory<Retailer,String>("retailerPassword"));        
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<Retailer,String>("productType"));               
        retailerPermanentColumn.setCellValueFactory(new PropertyValueFactory<Retailer,Boolean>("retailerPermanent"));        
        retailerDOJColumn.setCellValueFactory(new PropertyValueFactory<Retailer,LocalDate>("retailerDOJ"));
    }    

    @FXML
    private void toAddRetailerButtonOnClick(ActionEvent event)throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RetailerAdd.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @FXML
    private void clearTableButtonOnClick(ActionEvent event) {
        retailerTableView.getItems().clear();
    }

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        retailerTableView.getItems().clear();
        Retailer.LoadRetailerTable(retailerTableView);
    }
      
}
