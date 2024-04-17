/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private PasswordField passwordField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll(
            "CEO", "CFO", "Customer", "Regulatory Officer",
            "HR Manager", "Retailer", "System Administrator", "Shop Clerk"
        );
    } 

   
    @FXML
    private void newaccbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("NewAccountCreate.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }
    
    @FXML
    private void loginOnMouseClick(ActionEvent event) throws IOException {
        String userId = idTextField.getText();
        String userType = userTypeComboBox.getValue();
        String password = passwordField.getText();

        File userFile = new File(userType + "_" + userId + ".bin");

        try (FileInputStream fis = new FileInputStream(userFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            User user = (User) ois.readObject();

            if (user.getPassword().equals(password)) {
                String dashboard = getDashboard(userType);
                Parent dashboardParent = FXMLLoader.load(getClass().getResource(dashboard));
                Scene dashboardScene = new Scene(dashboardParent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(dashboardScene);
                stage.show();
            } else {
                System.out.println("Incorrect password.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("User not found.");
        }
    }

    private String getDashboard(String userType) {
        switch (userType) {
            case "CEO":
                return "ceoDashboard.fxml";
            case "CFO":
                return "CFOdashboard.fxml";
            case "Customer":
                return "DirectorDashboardScene.fxml";
            default:
                return ""; 
        }
    }
    

    
}
