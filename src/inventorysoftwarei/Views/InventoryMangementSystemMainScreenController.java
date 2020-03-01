/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import inventorysoftwarei.InventorySoftwareI;
import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.Part;
import inventorysoftwarei.Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
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
    TextField partSearchTXT;
    
    
    @FXML
    TableView<Product> productsTbl;
    @FXML
    TableColumn productIDCol;
    @FXML
    TableColumn productNameCol;
    @FXML
    TableColumn productInventoryCol;
    @FXML
    TableColumn productPriceCol;
    @FXML
    TextField productSearchTXT;
    
    
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
            IMSPartsModifyScreen.Receiver(inventory, selectedPart);


            window.setScene(partModifyScreenScene);
            window.show();
        }
    }
    
    @FXML
    private void handleProductAddBTN(ActionEvent event)throws IOExpception, IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/IMSProductAddScreen.fxml"));
        Parent productAddScreenParent = loader.load();
        Scene productAddScreenScene = new Scene (productAddScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        IMSProductAddScreenController IMSProductAddScreen = loader.getController();
        IMSProductAddScreen.InventoryReceiver(inventory);
        
        
        window.setScene(productAddScreenScene);
        window.show();
    }
    @FXML
    private void handleProductModifyBTN(ActionEvent event)throws IOExpception, IOException
    {
        Product selectedProduct = productsTbl.getSelectionModel().getSelectedItem();
        if(productsTbl.getSelectionModel().getSelectedItem() != null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/IMSProductModifyScreen.fxml"));
            Parent ProductModifyScreenParent = loader.load();
            Scene ProductModifyScreenScene = new Scene (ProductModifyScreenParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            IMSProductModifyScreenController IMSProductsModifyScreen = loader.getController();
            IMSProductsModifyScreen.Receiver(inventory, selectedProduct);


            window.setScene(ProductModifyScreenScene);
            window.show();
        }
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
        
        productIDCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));
        ObservableList<Product> productData = inventory.getAllProducts();
        
        productsTbl.setItems(productData);  
    }
    @FXML
    private void HandlePartSearchBTN()
    {
        RefreshPartsList(inventory.lookUpPart(partSearchTXT.getText()));
    }
    @FXML
    private void HandlePartDeleteBTN(ActionEvent event)
    {
        Part selectedPart = partsTbl.getSelectionModel().getSelectedItem();
        inventory.deletePart(selectedPart);
        
    }
    @FXML
    private void HandleProductDeleteBTN(ActionEvent event)
    {
        Product selectedProduct = productsTbl.getSelectionModel().getSelectedItem();
        inventory.deleteProduct(selectedProduct);
        
    }
    private void RefreshPartsList(ObservableList<Part> parts)
    {
        partsTbl.setItems(parts);
    }
    
    @FXML
    private void HandleProductSearchBTN()
    {
        RefreshProductsList(inventory.lookUpProduct(productSearchTXT.getText()));
    }
    private void RefreshProductsList(ObservableList<Product> Products)
    {
        productsTbl.setItems(Products);
    }
}
