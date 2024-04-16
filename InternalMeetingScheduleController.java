/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mrbaker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InternalMeetingScheduleController implements Initializable {

    @FXML
    private TextField meetingTitleTextField;
    @FXML
    private DatePicker meetingTimeDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    ArrayList<InternalMeeting> internalMeetingsList = new ArrayList();

    @FXML
    private void confirmScheduleMeetingOnClick(ActionEvent event) {
        
        long timestamp = System.currentTimeMillis();
        int meetingID = (int) (timestamp & 0xFFFFFFFF); // Code to generate unique ID always
        String meetingName = meetingTitleTextField.getText();
        LocalDate meetingTime = meetingTimeDatePicker.getValue();
        
        InternalMeeting newMeeting = new InternalMeeting(meetingID, meetingName, meetingTime);
        internalMeetingsList.add(newMeeting);
        
        MrBaker.ScheduleInternalMeeting(newMeeting);
    }
    
}
