/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user5project;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class CEOmeetingCallController implements Initializable {
    
    @FXML
    private CheckBox hrManagerCKBX;

    @FXML
    private CheckBox systemAdminCKBX;

    @FXML
    private CheckBox cfoCKBX;

    @FXML
    private CheckBox regulatoryOfficerCKBX;

    @FXML
    private TextField meetingInfoTF;

    
    
    @FXML
    void callForMeetingButton(ActionEvent event) throws IOException{
        
        String message = meetingInfoTF.getText();
        if (hrManagerCKBX.isSelected()) {
            FileWriter writer = new FileWriter("Notifications For HR Manager.txt", true);
            writer.write(message + "\n");
            writer.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your message has been sent");
            alert.showAndWait();
        }
        if (systemAdminCKBX.isSelected()) {
            FileWriter writer = new FileWriter("Notifications For System Administrator.txt", true);
            writer.write(message + "\n");
            writer.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your message has been sent");
            alert.showAndWait();
        }
        if (cfoCKBX.isSelected()) {
            FileWriter writer = new FileWriter("Notifications For CFO.txt", true);
            writer.write(message + "\n");
            writer.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your message has been sent");
            alert.showAndWait();
        }
        if (regulatoryOfficerCKBX.isSelected()) {
            FileWriter writer = new FileWriter("Notifications For Regulatory Officer.txt", true);
            writer.write(message + "\n");
            writer.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Your message has been sent");
            alert.showAndWait();
        }
        

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
