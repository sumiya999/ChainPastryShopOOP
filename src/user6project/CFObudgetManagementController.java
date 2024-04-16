package user6project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.text.Document;
import java.io.FileWriter;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;



public class CFObudgetManagementController implements Initializable {

    @FXML
    private TableView<Budget> budgetTV;
    @FXML
    private TableColumn<Budget, String> taskCol;
    @FXML
    private TableColumn<Budget, String> monthCol;
    @FXML
    private TableColumn<Budget, Integer> yearCol;
    @FXML
    private TableColumn<Budget, Integer> budgetCol;
    @FXML
    private TextField taskTF;
    @FXML
    private TextField yearTF;
    @FXML
    private TextField monthTF;
    @FXML
    private TextField budgetTF;
    
    private ObservableList<Budget> budgetList;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("Task")); 
        monthCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("Month"));
        yearCol.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Year"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<Budget,Integer>("Budget")); 
        
        
        budgetList = FXCollections.observableArrayList();
        budgetTV.setItems(budgetList);
    
        
    }   
   

    @FXML
    private void generateBudgetReportButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        File file = fileChooser.showSaveDialog(getWindow(event));

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Budget Report\n\n");

                for (Budget budget : budgetList) {
                    writer.write(budget.toString() + "\n");
                }

                showAlert("Success", "Report generated successfully.", AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to generate report.", AlertType.ERROR);
            }
        }
    }

    private Window getWindow(ActionEvent event) {
        return ((Node) event.getTarget()).getScene().getWindow();
    }

    private void showAlert(String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
    private void addNewBudgetButton(ActionEvent event) {
        Budget newBudget = new Budget(taskTF.getText(), monthTF.getText(),Integer.parseInt(yearTF.getText()) , Integer.parseInt(budgetTF.getText()));
        budgetList.add(newBudget);
        
        taskTF.clear();
        monthTF.clear();
        yearTF.clear();
        budgetTF.clear();
    }
    
}
