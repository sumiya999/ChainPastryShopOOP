
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mrbaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class MrBaker extends Employee implements Serializable {

    static void loadAdminRequestTable(TableView<AdminRequest> pendingRequestsTableView) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static AdminRequest getAdminRequest(int adminRequestToApproveID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void addRequestToFile(AdminRequest adminRequestToApprove) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public MrBaker(int employeeID, String employeeName, String employeePassword, String employeeType, double employeeSalary, boolean employeeFullTime, LocalDate employeeDOJ) {
        super(employeeID, employeeName, employeePassword, employeeType, employeeSalary, employeeFullTime, employeeDOJ);
    }
        public static void ScheduleInternalMeeting(InternalMeeting newMeeting) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ScheduledInternalMeetings.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newMeeting);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setHeaderText("Notice");
            a.setContentText("New Meeting Scheduled Successfully");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(InternalMeetingScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(InternalMeetingScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param scheduledMeetingsDisplayTextArea
     */
    public static void ViewInternalMeetings(TextArea scheduledMeetingsDisplayTextArea) {
        scheduledMeetingsDisplayTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("ScheduledInternalMeetings.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            InternalMeeting InternalMeeting;
            
            try{
                scheduledMeetingsDisplayTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    InternalMeeting = (InternalMeeting)ois.readObject();
                    System.out.println(InternalMeeting.toString());
                    scheduledMeetingsDisplayTextArea.appendText(InternalMeeting.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            scheduledMeetingsDisplayTextArea.appendText("\nAll internal meetings are to take place at 12PM unless stated otherwise.\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
   
    }
}    