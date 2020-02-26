/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
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
public class IMSProductAddScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ObservableList<Part> CurrentParts = FXCollections.observableArrayList();
    @FXML
    private TextField IDTXT;
    @FXML
    private TextField ProductNameTXT;
    @FXML
    private TextField InvTXT;
    @FXML
    private TextField PriceTXT;
    @FXML
    private TextField MaxTXT;
    @FXML
    private TextField MinTXT;
    @FXML
    private TableView<Part>  AllPartsTBL;
    @FXML
    TableColumn AllPartsIDCol;
    @FXML
    TableColumn AllPartsNameCol;
    @FXML
    TableColumn AllPartsInventoryCol;
    @FXML
    TableColumn AllPartsPriceCol;
    @FXML
    private TableView<Part> ProductPartsTBL;
    @FXML
    TableColumn ProductPartIDCol;
    @FXML
    TableColumn ProductPartNameCol;
    @FXML
    TableColumn ProductPartInventoryCol;
    @FXML
    TableColumn ProductPartPriceCol;
    @FXML
    private TextField SearchTXT;
    Inventory inventory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void InventoryReceiver(Inventory PassedInventory)
    {
        inventory = PassedInventory;
        int TempID = (inventory.GetProductCount() + 1);
        
        IDTXT.setText(String.valueOf(TempID));
        AllPartsIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        AllPartsNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        AllPartsInventoryCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        AllPartsPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
        ObservableList<Part> data = inventory.getAllParts();
        
        AllPartsTBL.setItems(data);
        ProductPartIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        ProductPartNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        ProductPartInventoryCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        ProductPartPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
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
    @FXML
    private void handleCancleBTN(ActionEvent event)throws IOExpception, IOException
    {
        ConfirmClose(event);
    }
    public void  ConfirmClose(ActionEvent event) throws IOException, IOException, IOExpception
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
    private void handleSaveBTN(ActionEvent event)
    {
        
    }
    @FXML
    private void handleAddBTN(ActionEvent event)
    {
        Part selectedPart = AllPartsTBL.getSelectionModel().getSelectedItem();
        boolean containsPart = false;
        if(AllPartsTBL.getSelectionModel().getSelectedItem() != null)
        {
            for(int i = 0; i < CurrentParts.size(); i++)
            {
                if(CurrentParts.get(i).getPartID() == selectedPart.getPartID())
                {
                   containsPart = true; 
                }
            }
            if(!containsPart)
            {
                CurrentParts.add(selectedPart);
                RefreshProductPartsList(CurrentParts);
            }

        }
    }
    @FXML
    private void HandlePartSearchBTN()
    {
        RefreshAllPartsList(inventory.lookUpPart(SearchTXT.getText()));
    }
    private void RefreshAllPartsList(ObservableList<Part> parts)
    {
        AllPartsTBL.setItems(parts);
    }
    private void RefreshProductPartsList(ObservableList<Part> parts)
    {
        ProductPartsTBL.setItems(parts);
    }
}
