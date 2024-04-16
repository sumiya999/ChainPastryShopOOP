
package user5project;

import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class CeoApprovalRequestsController implements Initializable {

    @FXML
    private TextArea showRequestTA;
    private FileChooser fileChooser;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void approveButton(ActionEvent event) {
        String reportDetails = showRequestTA.getText();
        if (!reportDetails.isEmpty()) {
            System.out.println("Request Approved:\n" + reportDetails);
            showRequestTA.clear();
        
            showApprovalAlert("Request Approved", "The request has been approved.");
        } else {
            System.out.println("No request to approve.");
        }
    }
    
    private void showApprovalAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }

    @FXML
    private void declineButton(ActionEvent event) {
        String reportDetails = showRequestTA.getText();
        if (!reportDetails.isEmpty()) {
            System.out.println("Request Declined:\n" + reportDetails);
            showRequestTA.clear();
        
            showDeclineAlert("Request Declined", "The request has been declined.");
        } else {
            System.out.println("No request to decline.");
        }
    }
    
    private void showDeclineAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }    

    @FXML
    private void showRequestButton(ActionEvent event) {
        String filePath = "C:\\Users\\sumiya\\OneDrive\\Documents\\NetBeansProjects\\ChainPastryShop\\src\\user5project\\ceoApprovalRequest.txt";
    
        File file = new File(filePath);
        if (file.exists()) {
            String reportDetails = readReportDetailsFromFile(file);
            showRequestTA.setText(reportDetails);
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }
    
    private String readReportDetailsFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            java.util.Scanner scanner = new java.util.Scanner(file);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    
    @FXML
    private void backToHomeButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoDashborad.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    
}
