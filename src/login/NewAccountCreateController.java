/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NewAccountCreateController implements Initializable {

    @FXML
    private ComboBox<String> selectuserComboBox;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField useridTextField;
    @FXML
    private PasswordField passwordField;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectuserComboBox.getItems().addAll("CEO", "CFO", "Customer", "Regulatory Officer", "HR Manager", "Retailer", "System Administrator", "Shop Clerk");
        
    }    
    
    

    @FXML
    private void signUpOnMouseClick(ActionEvent event){
        String username = usernameTextField.getText();
        String userId = useridTextField.getText();
        String userType = selectuserComboBox.getValue();
        String password = passwordField.getText();
        
        if (username.isEmpty() || userId.isEmpty() || userType == null || password.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }
        
        File userFile = new File(userType + "_" + userId + ".bin");
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile))) {
            User user = new User(username, userId, userType, password); 
            oos.writeObject(user);
            
            System.out.println("User account created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }
        


}   
   
