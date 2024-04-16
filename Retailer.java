/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrbaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author ASUS
 */
public class Retailer implements Serializable {

    static void WriteRetailerToRetailerFile(Retailer newRetailer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    protected int retailerId;
    protected String retailerName;
    protected String retailerPassword;
    protected String productType;
    //protected String retailerPhone;
    //protected LocalDate retailerDOB;
    protected LocalDate retailerDOJ; 
    protected boolean retailerPermanent;
    
    
    public Retailer(int retailerId, String retailerName, String retailerPassword, String productType, boolean retailerPermanent, LocalDate retailerDOJ) {
    this.retailerId = retailerId;
    this.retailerName = retailerName;
    this.retailerPassword = retailerPassword;
    this.productType = productType;
    //this.retailerPhone = retailerPhone;
    //this.retailerDOB = retailerDOB;
    this.retailerDOJ = retailerDOJ;
    
    this.retailerPermanent = retailerPermanent;
    }
    
    public static void WriteEmployeeToRetailerFile(Retailer newRetailer) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("RetailerObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newRetailer);
            
            Alert retailerAdded = new Alert(Alert.AlertType.INFORMATION);
            retailerAdded.setTitle("Success");
            retailerAdded.setHeaderText("Retailer Added");
            retailerAdded.setContentText("Retailer has been added successfully");
            retailerAdded.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(RetailerAddController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RetailerAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void WriteRetailerToLoginFile(Retailer newRetailer) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("LoginObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newRetailer);

        } catch (IOException ex) {
            Logger.getLogger(RetailerAddController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RetailerAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void LoadRetailerTable(TableView retailerTableView) {
        
        ObjectInputStream ois=null;
         try {
            Retailer ret;
            ois = new ObjectInputStream(new FileInputStream("RetailerObjects.bin"));
            
            while (true) {
                ret = (Retailer) ois.readObject();
                retailerTableView.getItems().add(ret);
                ret = (Retailer) ois.readObject(); retailerTableView.getItems().add(ret);                
            }
                        
            
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
        
    }

    Retailer(String retailerName, String retailerPassword, String retailerType, LocalDate retailerDOJ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Retailer(int i, String retailer, String string, String notype, int i0, boolean b, LocalDate now) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public String toString() {
        return "Retailer{" + "retailerID=" + retailerId + ", retailerName=" + retailerName + ", retailerPassword=" + retailerPassword + ", productType=" + productType + ", retailerDOJ=" + retailerDOJ + ", retailerPermanent=" + retailerPermanent+ '}';
    }
    public int getRetailerId() {
        return retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getRetailerPassword() {
        return retailerPassword;
    }

    public String getProductType() {
        return productType;
    }

    public LocalDate getRetailerDOJ() {
        return retailerDOJ;
    }

    public boolean isRetailerPermanent() {
        return retailerPermanent;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public void setRetailerPassword(String retailerPassword) {
        this.retailerPassword = retailerPassword;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setRetailerDOJ(LocalDate retailerDOJ) {
        this.retailerDOJ = retailerDOJ;
    }

    public void setRetailerPermanent(boolean retailerPermanent) {
        this.retailerPermanent = retailerPermanent;
    }
    
public static Retailer getRetailer(int retailerID) {
        
        ObjectInputStream ois=null;
         try {
            Retailer ret;
            ois = new ObjectInputStream(new FileInputStream("RetailerObjects.bin"));
            
            while (true) {
                ret = (Retailer) ois.readObject();
                
                if (ret.getRetailerId() == retailerID) {
                    return ret;
                }            
            }
                        
            
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
        Retailer ret = new Retailer(1, "employee", "1234", "notype", 1000, false, LocalDate.now());
        return ret;
    }
    
}

    





   