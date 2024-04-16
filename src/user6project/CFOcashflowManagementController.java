/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package user6project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumiya
 */
public class CFOcashflowManagementController implements Initializable {

    @FXML
    private TableView<CashflowEntry> cashflowManagementTV;
    @FXML
    private TableColumn<CashflowEntry, LocalDate> dateCol;
    @FXML
    private TableColumn<CashflowEntry, String> descriptionCol;
    @FXML
    private TableColumn<CashflowEntry, Double> cashInflowsCol;
    @FXML
    private TableColumn<CashflowEntry, Double> cashOutflowsCol;
    @FXML
    private TableColumn<CashflowEntry, Double> netCashflowCol;
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField cashOutflowsTF;
    @FXML
    private TextField cashInflowsTF;
    @FXML
    private DatePicker datePicker;
    
    private ObservableList<CashflowEntry> cashflowEntries;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        cashInflowsCol.setCellValueFactory(new PropertyValueFactory<>("cashInflows"));
        cashOutflowsCol.setCellValueFactory(new PropertyValueFactory<>("cashOutflows"));
        netCashflowCol.setCellValueFactory(new PropertyValueFactory<>("netCashflow"));

        cashflowEntries = FXCollections.observableArrayList();

        cashflowManagementTV.setItems(cashflowEntries);
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
    private void generateCashflowReportButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Existing Cashflow Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File existingFile = new File("CashFlow report.txt");
        
        if (existingFile.exists()) {
        File existingFileDirectory = existingFile.getParentFile();
            if (existingFileDirectory != null && existingFileDirectory.exists()) {
                fileChooser.setInitialDirectory(existingFileDirectory);
            }
        }
        
        File selectedFile = fileChooser.showOpenDialog(null);


        if (selectedFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(existingFile, true))) {
                writer.newLine();
                writer.write("Cashflow Report");
                writer.newLine();
                writer.write("Date\tDescription\tCash Inflows\tCash Outflows\tNet Cashflow");
                writer.newLine();

                List<CashflowEntry> entries = cashflowManagementTV.getItems();
                for (CashflowEntry entry : entries) {
                    writer.write(String.format("%s\t%s\t%.2f\t%.2f\t%.2f",
                        entry.getDate(),
                        entry.getDescription(),
                        entry.getCashInflows(),
                        entry.getCashOutflows(),
                        entry.getNetCashflow()));
                    writer.newLine();
                }
            
                System.out.println("Cashflow report appended to existing text file.");
                showSuccessAlert("Cashflow Report Generated", "The cashflow report has been successfully generated and appended to the existing file.");

            } catch (IOException e) {
                System.err.println("Error appending cashflow report to existing text file: " + e.getMessage());
            }
        }
    }
    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    @FXML
    private void addButtonAction(ActionEvent event) {
        String description = descriptionTF.getText();
        double cashInflows = Double.parseDouble(cashInflowsTF.getText());
        double cashOutflows = Double.parseDouble(cashOutflowsTF.getText());
        LocalDate date = datePicker.getValue();

        double netCashflow = cashInflows - cashOutflows;

        CashflowEntry entry = new CashflowEntry(date, description, cashInflows, cashOutflows, netCashflow);

        cashflowEntries.add(entry);


        clearInputFields();
    }
    
    private void clearInputFields() {
        descriptionTF.clear();
        cashInflowsTF.clear();
        cashOutflowsTF.clear();
        datePicker.setValue(null);
    }
    
}
