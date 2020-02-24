/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import inventorysoftwarei.Model.InHousePart;
import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.OutSourcedPart;
import inventorysoftwarei.Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Djok
 */
public class IMSPartsAddScreenController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    Inventory inventory = new Inventory();    
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
    @FXML
    private Button SaveBTN;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOStage 

    }
    public void  ConfirmClose(ActionEvent event) throws IOException, IOException, IOExpception
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Cancle add part?");
        alert.setContentText("This Will Not Save");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            MainScreenSwap(event);
        } 
        else 
        {

        }
    }    
    @FXML
    private void handleCancleBTN(ActionEvent event)throws IOExpception, IOException
    {
        ConfirmClose(event);
    } 
    @FXML
    private void handleSaveBTN(ActionEvent event)throws IOExpception, IOException
    {
        String errors;

        try
        {
         errors = Part.formCompleat(Integer.parseInt(MaxTXT.getText()), Integer.parseInt(MinTXT.getText()), Integer.parseInt(InvTXT.getText()), Double.parseDouble(PriceTXT.getText()), PartNameTXT.getText());       
           if(errors == null || "".equals(errors))
           {
                if(InHouse.isSelected())
                {
                    try
                    {
                        int Check = Integer.parseInt(CompanyNameTXT.getText());
                        InHousePart newPart = new InHousePart(inventory.nextPartID(), Integer.parseInt(MaxTXT.getText()), Integer.parseInt(MinTXT.getText()), Integer.parseInt(InvTXT.getText()), Double.parseDouble(PriceTXT.getText()), PartNameTXT.getText(), Integer.parseInt(CompanyNameTXT.getText()));
                        inventory.addPart(newPart);
                        MainScreenSwap(event);
                    }
                    catch(NumberFormatException e)
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Only Numbers Please");
                        alert.setHeaderText(null);
                        alert.setContentText("Machine ID must be int.");

                        alert.showAndWait();
                    }
                }
                else if(OutSource.isSelected())
                {
                   OutSourcedPart newPart = new OutSourcedPart(inventory.nextPartID(), Integer.parseInt(MaxTXT.getText()), Integer.parseInt(MinTXT.getText()), Integer.parseInt(InvTXT.getText()), Double.parseDouble(PriceTXT.getText()), PartNameTXT.getText(), CompanyNameTXT.getText());
                   inventory.addPart(newPart);
                   MainScreenSwap(event);
                }
                
                
           }
           else
           {
               Alert alert = new Alert(AlertType.WARNING);
               alert.setTitle("Missing or Incorrect info");
               alert.setHeaderText(null);
               alert.setContentText(errors);

               alert.showAndWait();
           }
        }
        catch(NumberFormatException e)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Only Numbers Please");
            alert.setHeaderText(null);
            alert.setContentText("Min, Max, and Inventory are only whole numbers. Price may be a decmial.");

            alert.showAndWait();
        }
    }
        
    @FXML
    private void InHouseRB()
    {
        CompanyNameLBL.setText("Machine ID");
        CompanyNameTXT.setPromptText("Machine ID");
        SaveBTN.setDisable(false);
    }
    @FXML
    private void OutsourcedRB()
    {
        CompanyNameLBL.setText("Company Name");
        CompanyNameTXT.setPromptText("Company Name");
        SaveBTN.setDisable(false);
    }
    
    public void InventoryReceiver(Inventory PassedInventory)
    {
        inventory = PassedInventory;
        int TempID = (inventory.GetPartCount() + 1);
        
        IDTXT.setText(String.valueOf(TempID));
    }
    
    private void MainScreenSwap(ActionEvent event) throws IOExpception, IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/InventoryMangementSystemMainScreen.fxml"));
        Parent partAddScreenParent = loader.load();
        Scene partAddScreenScene = new Scene (partAddScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        InventoryMangementSystemMainScreenController InventoryMangementSystemMainScreen = loader.getController();
        InventoryMangementSystemMainScreen.InventoryReceiver(inventory);
        
        
        window.setScene(partAddScreenScene);
        window.show();
    }

}

