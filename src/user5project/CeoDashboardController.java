
package user5project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class CeoDashboardController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private ComboBox<String> realTimeAnalyticsCB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        realTimeAnalyticsCB.getItems().addAll("Financial Metrics","Customer Engagement","Employee Productivity","Sales Performance");
    }
    @FXML
    void meetingsAndAnnoucementsButtonAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("CEOmeetingCall.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();

    }

    @FXML
    private void realTimeAnalyticsEnterButton(ActionEvent event) throws IOException {
        String selectedOption = realTimeAnalyticsCB.getValue();
            if (selectedOption != null && selectedOption.equals("Financial Metrics")) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoFinancialMetrics.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg2.setScene(scene2);
                stg2.show();
            }
            
            if (selectedOption != null && selectedOption.equals("Customer Engagement")) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoCustomerEngagementCheck.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg2.setScene(scene2);
                stg2.show();
            }
            
            if (selectedOption != null && selectedOption.equals("Employee Productivity")) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoEmployeeProductivityCheck.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg2.setScene(scene2);
                stg2.show();
            }
            
            if (selectedOption != null && selectedOption.equals("Sales Performance")) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoSalesPerformanceCheck.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                stg2.setScene(scene2);
                stg2.show();
            }  
    }

    @FXML
    private void approvalRequestsButtonAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ceoApprovalRequests.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void logOutButtonAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
        
    }
    
    
}



