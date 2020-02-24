/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.Part;
import inventorysoftwarei.Model.OutSourcedPart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Djok
 */
public class IMSPartsModifyScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Inventory inventory = new Inventory();  
    int currentPartID;
    @FXML
    private TextField PartNameTXT;
    @FXML
    private TextField IDTXT;      
    @FXML
    private TextField InvTXT;    
    @FXML
    private TextField PriceTXT;    
    @FXML
    private TextField MaxTXT;      
    @FXML
    private TextField MinTXT;      
    @FXML
    private TextField CompanyNameTXT;  
    @FXML
    private Text CompanyNameLBL;
    @FXML
    private RadioButton InHouse;
    @FXML
    private RadioButton OutSource;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void Receiver(Inventory PassedInventory)
    {
        inventory = PassedInventory;       
    }
    
}
