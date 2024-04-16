/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOreportsController implements Initializable {

    @FXML
    private TextField reportDetailsAndDateTF;
    @FXML
    private ComboBox<String> reportTypeCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reportTypeCB.getItems().addAll("Budget","Tax","Cashflow","Revenue Forecast");        
        
    }    

    @FXML
    private void sendReportToCeoButton(ActionEvent event){
        String message = reportDetailsAndDateTF.getText();
        File file = new File("Report.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(message + "\n");
            writer.write("Dear CEO,\n");
            writer.write("Here is the report for this month.\n");
            writer.write("Please review it at your earliest convenience.\n");
            writer.write("Sincerely,\n");
            writer.write("Arif Hasan, CFO");
            writer.close();

            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your Report has been sent");
            alert.showAndWait();
        } catch (IOException e) {
        }
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
    private void addReportButton(ActionEvent event) {
        String selectedReportType = reportTypeCB.getValue();
        String fileName = selectedReportType + "_Report.txt";

        File file = new File(fileName);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Report Type: " + selectedReportType + "\n");
            writer.close();
            System.out.println("Report file created: " + fileName);
        } catch (IOException e) {
        }
        
    }
    
}
