/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOannouncementsController implements Initializable {

    @FXML
    private TextField meetingNotificationTF;
    @FXML
    private TextField responseTF;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void responseButton(ActionEvent event) throws IOException {
        String message = responseTF.getText();
        FileWriter writer = new FileWriter("CFOmeetingResponse.txt", true);
        writer.write(message + "\n");
        writer.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Your response has been sent");
        alert.showAndWait();
    }

    @FXML
    private void meetingCallsButton(ActionEvent event) {
        try {
        File f = new File("Notifications For CFO.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        meetingNotificationTF.clear();

        String line;
        String lastLine= null;
        while ((line = br.readLine()) != null) {
            lastLine = line;
        }
        
        if(lastLine!=null){
            meetingNotificationTF.setText(lastLine);

        }
        br.close(); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    
}
