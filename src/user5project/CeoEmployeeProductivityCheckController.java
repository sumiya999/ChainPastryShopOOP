/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user5project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CeoEmployeeProductivityCheckController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private ComboBox<String> branchCB;
    @FXML
    private ComboBox<String> positionCB;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        branchCB.getItems().addAll("Branch 1", "Branch 2", "Branch 3");
        positionCB.getItems().addAll("Cashier", "Barista", " Manager");
        
    }    

    @FXML
    private void backToHomeButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void viewActivityButton(ActionEvent event) {
        String selectedBranch = branchCB.getValue();
        String selectedPosition = positionCB.getValue();

        pieChart.getData().clear();

        if (selectedBranch != null && selectedPosition != null) {
            if (selectedBranch.equals("Branch 1")) {
                if (selectedPosition.equals("Cashier")) {
                    pieChart.getData().add(new PieChart.Data("Quality of Work", 30));
                    pieChart.getData().add(new PieChart.Data("Working speed", 20));
                    pieChart.getData().add(new PieChart.Data("Handling Problems", 10));
                    pieChart.getData().add(new PieChart.Data(" Communication Skills", 30));

                    
                } else if (selectedPosition.equals("Manager")) {
                    pieChart.getData().add(new PieChart.Data("Quality of Work", 50));
                    pieChart.getData().add(new PieChart.Data("Working speed", 20));
                    pieChart.getData().add(new PieChart.Data("Handling Problems", 30));
                    pieChart.getData().add(new PieChart.Data(" Communication Skills", 30));                   
                }
                } else if (selectedPosition.equals("Barista")) {
                    pieChart.getData().add(new PieChart.Data("Quality of Work", 30));
                    pieChart.getData().add(new PieChart.Data("Working speed", 20));
                    pieChart.getData().add(new PieChart.Data("Handling Problems", 10));
                    pieChart.getData().add(new PieChart.Data(" Communication Skills", 30));                    
                }
            } else if (selectedBranch.equals("Branch 2")) {
                // Add data for Branch 2
            } else if (selectedBranch.equals("Branch 3")) {
                // Add data for Branch 3
            }
    }
    
    
}
