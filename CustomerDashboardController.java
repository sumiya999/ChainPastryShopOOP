/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customer;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CustomerDashboardController implements Initializable {

    @FXML
    private ComboBox<String> FTQuantityComboBox;
    @FXML
    private ComboBox<String> MsQuantityComboBox;
    @FXML
    private ComboBox<String> BPQuantityComboBox;
    @FXML
    private ComboBox<String> BFQuantityComboBox;
    @FXML
    private ComboBox<String> BRPQuantityComboBox;
    @FXML
    private ComboBox<String> PPQuantityComboBox;
    @FXML
    private ComboBox<String> CPQuantityComboBox;
    @FXML
    private ComboBox<String> GPQuantityComboBox;
    @FXML
    private ComboBox<String> MCQuantityComboBox;
    @FXML
    private ComboBox<String> MFPQuantityComboBox;
    @FXML
    private ComboBox<String> SPQuantityComboBox;
    @FXML
    private ComboBox<String> CRQuantityComboBox;
    
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    SceneLoader newSceneLoader = new SceneLoader();
    Customer loggedCustInst = LoggedUserInstance.custInst;

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         FTQuantityComboBox.getItems().addAll("1","2","3","4","5");
         MsQuantityComboBox.getItems().addAll("1","2","3","4","5");
         BPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         BFQuantityComboBox.getItems().addAll("1","2","3","4","5");
         BRPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         PPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         CPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         GPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         MCQuantityComboBox.getItems().addAll("1","2","3","4","5");
         MFPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         SPQuantityComboBox.getItems().addAll("1","2","3","4","5");
         CRQuantityComboBox.getItems().addAll("1","2","3","4","5");


        
    }   
    
        @FXML
    private void ftbutton(MouseEvent event) {
        if( FTQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("FRUIT TART In",  FTQuantityComboBox.getValue(), 10, 800);
            FTQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void msbutton(MouseEvent event) {
        if(MsQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Tehari Cut", MsQuantityComboBox.getValue(), 10, 850);
            MsQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
        
    }
    


    @FXML
    private void bpbutton(MouseEvent event) {
        if(BPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Tenderloin Steak", BPQuantityComboBox.getValue(), 10, 1200);
            BPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void bfbutton(MouseEvent event) {
        if(BFQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", BFQuantityComboBox.getValue(), 15, 1500);
            BFQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void rpbutton(MouseEvent event) {
        if(BRPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", BRPQuantityComboBox.getValue(), 15, 1500);
            BRPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void ppbutton(MouseEvent event) {
        if(PPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", PPQuantityComboBox.getValue(), 15, 1500);
            PPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void cpbutton(MouseEvent event) {
        if(CPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", CPQuantityComboBox.getValue(), 15, 1500);
            CPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void gpbutton(MouseEvent event) {
        if(GPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", GPQuantityComboBox.getValue(), 15, 1500);
            GPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void mcbutton(MouseEvent event) {
        if(MCQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", MCQuantityComboBox.getValue(), 15, 1500);
            MCQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void mfpbutton(MouseEvent event) {
        if(MFPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", MFPQuantityComboBox.getValue(), 15, 1500);
            MFPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void spbutton(MouseEvent event) {
        if(SPQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", SPQuantityComboBox.getValue(), 15, 1500);
            SPQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void crbutton(MouseEvent event) {
        if(CRQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", CRQuantityComboBox.getValue(), 15, 1500);
            CRQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

//    @FXML
//    private void checkoutBtnOnClick(ActionEvent event) {
//        if(loggedCustInst.checkOut()) {
//            newSceneLoader.loadScene("CheckoutScene.fxml");
//        }
//        else {
//            anInfoAlert.setContentText("Your cart is empty. Add item(s) to the cart to checkout.");
//            anInfoAlert.show();
//        }
//    }
    
//    @FXML
//    private void rtrnHomeBtnOnClick(MouseEvent event) throws IOException {
//        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
//    }
    
    
    @FXML
    private void gotocartbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
          
    }
 
    private static class SceneLoader {

        public SceneLoader() {
        }
    }

    private static class LoggedUserInstance {

        private static Customer custInst;

        public LoggedUserInstance() {
        }
    }
    
}
    

