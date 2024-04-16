/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
public class CFOforecastRevenueController implements Initializable {

    @FXML
    private TableView<RevenueEntry> forecastRevenueTV;
    @FXML
    private TableColumn<RevenueEntry, LocalDate> dateCol;
    @FXML
    private TableColumn<RevenueEntry, String> descriptionCol;
    @FXML
    private TableColumn<RevenueEntry, Double> projectedRevenueCol;
    @FXML
    private TableColumn<RevenueEntry, Double> totalRevenueCol;
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField projectedRevenueTF;
    @FXML
    private DatePicker datePicker;
    
    private ObservableList<RevenueEntry> revenueEntries = FXCollections.observableArrayList();


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        projectedRevenueCol.setCellValueFactory(new PropertyValueFactory<>("projectedRevenue"));
        totalRevenueCol.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));

        forecastRevenueTV.setItems(revenueEntries);
        
    }    

    @FXML
    private void backToHomeButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("CFOdashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void generateRevenueReportButton(ActionEvent event) {
    }

    @FXML
    private void addButton(ActionEvent event) {
        String description = descriptionTF.getText();
        double projectedRevenue = Double.parseDouble(projectedRevenueTF.getText());
        LocalDate date = datePicker.getValue();

        RevenueEntry entry = new RevenueEntry(date, description, projectedRevenue);
        revenueEntries.add(entry);

        descriptionTF.clear();
        projectedRevenueTF.clear();
        datePicker.setValue(null);
    }

    @FXML
    private void showTotalRevenueButton(ActionEvent event) {
        double totalRevenue = 0;
        for (RevenueEntry entry : revenueEntries) {
            totalRevenue += entry.getProjectedRevenue();
        }
        revenueEntries.add(new RevenueEntry(null, "Total Revenue", totalRevenue));
    }
    
}
