/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import inventorysoftwarei.InventorySoftwareI;
import inventorysoftwarei.Model.InHousePart;
import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.Part;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Djok
 */
public class InventoryMangementSystemMainScreenController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    Inventory inventory = new Inventory();    
    
    @FXML
    TableView<Part> partsTbl;
    @FXML
    TableColumn partIDCol;
    @FXML
    TableColumn partNameCol;
    @FXML
    TableColumn partInventoryCol;
    @FXML
    TableColumn partPriceCol;
    
    
    
    @FXML
    private void handlePartAddBTN(ActionEvent event)throws IOExpception, IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/IMSPartsAddScreen.fxml"));
        Parent partAddScreenParent = loader.load();
        Scene partAddScreenScene = new Scene (partAddScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        IMSPartsAddScreenController IMSPartsAddScreen = loader.getController();
        IMSPartsAddScreen.InventoryReceiver(inventory);
        
        
        window.setScene(partAddScreenScene);
        window.show();
    }
    @FXML
    private void handlePartModifyBTN(ActionEvent event)throws IOExpception, IOException
    {
        Part selectedPart = partsTbl.getSelectionModel().getSelectedItem();
        if(partsTbl.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/IMSPartsModifyScreen.fxml"));
            Parent partModifyScreenParent = loader.load();
            Scene partModifyScreenScene = new Scene (partModifyScreenParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            IMSPartsModifyScreenController IMSPartsModifyScreen = loader.getController();
            IMSPartsModifyScreen.Receiver(inventory);


            window.setScene(partModifyScreenScene);
            window.show();
        }
    }
    
    @FXML
    private void handleProductAddBTN(ActionEvent event)throws IOExpception, IOException
    {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/IMSProductAddScreen.fxml"));
        Parent productAddScreenParent = loader.load();
        Scene productAddScreenScene = new Scene (productAddScreenParent);
        
        IMSPartsAddScreenController IMSPartsAddScreen = loader.getController();
        IMSPartsAddScreen.InventoryReceiver(inventory);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(productAddScreenScene);
        window.show();
    }
    @FXML
    private void handleProductModifyBTN(ActionEvent event)throws IOExpception, IOException
    {
        Parent productModifyScreenParent = FXMLLoader.load(getClass().getResource("/inventorysoftwarei/Views/IMSProductModifyScreen.fxml"));
        Scene productModifyScreenScene = new Scene (productModifyScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(productModifyScreenScene);
        window.show();
    }
    @FXML
    private void handleExitBTN(ActionEvent event)
    {
        if(InventorySoftwareI.ConfirmClose())
        {
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        
    }   
    
    public void InventoryReceiver(Inventory PassedInventory)
    {
        inventory = PassedInventory;
        
        partIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
        ObservableList<Part> data = inventory.getAllParts();
        
        partsTbl.setItems(data);
    }
    
    @FXML
    private void HandlePartDeleteBTN(ActionEvent event)
    {
        Part selectedPart = partsTbl.getSelectionModel().getSelectedItem();
        inventory.deletePart(selectedPart);
        
    }
    
    private void RefreshList()
    {
        partsTbl.setItems(inventory.getAllParts());
    }
    
    
}
