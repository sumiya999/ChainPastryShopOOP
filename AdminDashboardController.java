/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mrbaker;

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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class AdminDashboardController implements Initializable {

    @FXML
    private Label mrbakerlabel1;
    @FXML
    private Label mrbakerlabel2;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label label;
    @FXML
    private Label label1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EmpolyeeSectionButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("EmployeeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void RetailerSectionButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RetailerScene.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void PendingApplicationsSectionButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PendingApplicationsScene.fxml"));
        borderPane.setCenter(parent); 
    }

    @FXML
    private void AnnouncementSectionButtonOnClick(ActionEvent event)throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("Announcement.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void OperationsSectionButtonOnClick(ActionEvent event)throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("InternalMeeting.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void SignOutButtonOnClick(ActionEvent event)throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene admindashboard = new Scene(mainSceneParent);
            Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(admindashboard);
            stg2.show();
        
    }

    }

