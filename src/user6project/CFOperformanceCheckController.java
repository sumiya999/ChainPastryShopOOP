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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOperformanceCheckController implements Initializable {

    @FXML
    private ComboBox<String> selectBranchCB;
    @FXML
    private LineChart<Number, Number> performanceLC;

    private final ObservableList<String> branchOptions = FXCollections.observableArrayList(
        "Branch 1", "Branch 2", "Branch 3"
    );
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectBranchCB.setItems(branchOptions);  
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
    private void enterButton(ActionEvent event) {
        String selectedBranch = selectBranchCB.getValue();
        if ("Branch 1".equals(selectedBranch)) {
            XYChart.Series series = new XYChart.Series();
            series.setName(selectedBranch);
            series.getData().add(new XYChart.Data(1, 100));
            series.getData().add(new XYChart.Data(2, 90));
            series.getData().add(new XYChart.Data(3, 89));
            performanceLC.getData().clear();
            performanceLC.getData().add(series);
        }
        if ("Branch 2".equals(selectedBranch)) {
            XYChart.Series series = new XYChart.Series();
            series.setName(selectedBranch);
            series.getData().add(new XYChart.Data(1, 90));
            series.getData().add(new XYChart.Data(2, 70));
            series.getData().add(new XYChart.Data(3, 65));
            performanceLC.getData().clear();
            performanceLC.getData().add(series);
        }
        if ("Branch 3".equals(selectedBranch)) {
            XYChart.Series series = new XYChart.Series();
            series.setName(selectedBranch);
            series.getData().add(new XYChart.Data(1, 95));
            series.getData().add(new XYChart.Data(2, 90));
            series.getData().add(new XYChart.Data(3, 79));
            performanceLC.getData().clear();
            performanceLC.getData().add(series);
        }
        
    }
    
}
