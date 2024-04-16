/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.awt.Desktop;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOretailerPageController implements Initializable {

    @FXML
    private TextArea negotiatePricingAndDiscountTA;
    @FXML
    private TextArea longTermAgreementTA;
    @FXML
    private TextArea PaymentTermsTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void paymentTermsButton(ActionEvent event) {
        File file = new File("C:\\Users\\sumiya\\OneDrive\\Documents\\NetBeansProjects\\ChainPastryShop\\src\\user6project\\paymentTerm.txt"); 

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                PaymentTermsTA.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found: paymentTerm.txt");
        }
    }

    @FXML
    private void longTermAgreementButton(ActionEvent event) {
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
    private void callMeetingWithRetailerButton(ActionEvent event) {
    }
    

}
