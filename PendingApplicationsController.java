/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mrbaker;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PendingApplicationsController implements Initializable {

    @FXML
    private TextField requestIDToApproveTextField;
    @FXML
    private TableView<AdminRequest> pendingRequestsTableView;
    @FXML
    private TableColumn<AdminRequest, Integer> requestIDTableColumn;
    @FXML
    private TableColumn<AdminRequest, String> requestContentTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("adminRequestID"));
        requestContentTableColumn.setCellValueFactory(new PropertyValueFactory<>("adminRequestContent"));
        MrBaker.loadAdminRequestTable(pendingRequestsTableView);
    }    

    @FXML
    private void approveRequestButtonOnClick(ActionEvent event) {
        try {
            int adminRequestToApproveID = Integer.parseInt(requestIDToApproveTextField.getText());
        
            AdminRequest adminRequestToApprove = MrBaker.getAdminRequest(adminRequestToApproveID);
            MrBaker.addRequestToFile(adminRequestToApprove);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Request ID");
            alert.setContentText("Please enter a valid integer for the Request ID.");
            alert.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(PendingApplicationsController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Approving Request");
            alert.setContentText("An error occurred while approving the request.");
            alert.showAndWait();
        }
    }
}