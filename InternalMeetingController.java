/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mrbaker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InternalMeetingController implements Initializable {

    @FXML
    private TextArea scheduledMeetingsDisplayTextArea;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MrBaker.ViewInternalMeetings(scheduledMeetingsDisplayTextArea); 
    }    

    @FXML
    private void refreshButtonOnClick(ActionEvent event)throws IOException {
        MrBaker.ViewInternalMeetings(scheduledMeetingsDisplayTextArea);
    }

    @FXML
    private void scheduleMeetingButtonOnClick(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InternalMeetingSchedule.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }
    }
    
