/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package regulatoryofficer;

import java.io.BufferedWriter;
import java.io.File;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AuditReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void auhomebutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
          
    }
    
//        @FXML
//    private boolean submitbutton(ActionEvent event) {
//        
//        File f = null;
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        f = new File("InternalAnnouncement.bin");
//        if (f.exists()) {
//            fos = new FileOutputStream(f);
//            oos = new AppendableObjectOutputStream(fos);
//            
//        } else {
//            fos = new FileOutputStream(f);
//            oos = new ObjectOutputStream(fos);
//        }
//        oos.writeObject();
//        oos.close();
//        return true;
//
//    }  
    @FXML
    private TextField audittextfield;
    @FXML
    private void submitbutton() {
        String announcement =audittextfield.getText();
        saveAnnouncementToFile(announcement);
    }

    private void saveAnnouncementToFile(String announcement) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Audit.txt"))) {
            writer.write(announcement);
        } catch (IOException e) {
        }
    }
    
}
