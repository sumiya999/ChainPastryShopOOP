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
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CeoSalesPerformanceCheckController implements Initializable {

    @FXML
    private AreaChart<Number,Number> salesPerformanceAC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Days");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Sale");


        salesPerformanceAC.setTitle("Sale Performance");
        salesPerformanceAC.setLegendVisible(false); 
        salesPerformanceAC.setCreateSymbols(false); 

        XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
        series.getData().add(new XYChart.Data<Number,Number>(1, 20)); 
        series.getData().add(new XYChart.Data<Number,Number>(2, 35)); 
        series.getData().add(new XYChart.Data<Number,Number>(3, 28)); 
        series.getData().add(new XYChart.Data<Number,Number>(5, 50)); 
        series.getData().add(new XYChart.Data<Number,Number>(6, 35)); 
        series.getData().add(new XYChart.Data<Number,Number>(8, 28));
        series.getData().add(new XYChart.Data<Number,Number>(9, 20)); 
        series.getData().add(new XYChart.Data<Number,Number>(10, 35)); 
        series.getData().add(new XYChart.Data<Number,Number>(11, 78));
        series.getData().add(new XYChart.Data<Number,Number>(12, 70)); 
        series.getData().add(new XYChart.Data<Number,Number>(13, 35)); 
        series.getData().add(new XYChart.Data<Number,Number>(15, 28));
        series.getData().add(new XYChart.Data<Number,Number>(18, 50)); 
        series.getData().add(new XYChart.Data<Number,Number>(20, 35)); 
        series.getData().add(new XYChart.Data<Number,Number>(21, 28));
        series.getData().add(new XYChart.Data<Number,Number>(22, 85)); 
        series.getData().add(new XYChart.Data<Number,Number>(23, 98));

        salesPerformanceAC.getData().add(series);
    }    

    @FXML
    private void backToHomeButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }
    
}
