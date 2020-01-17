/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


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
    
    @FXML
    private void handlePartAddBTN(ActionEvent event)throws IOExpception, IOException
    {
        Parent partAddScreenParent = FXMLLoader.load(getClass().getResource("IMSPartsAddScreen.fxml"));
        Scene partAddScreenScene = new Scene (partAddScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        /*window.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                }
            });*/
        window.setScene(partAddScreenScene);
        window.show();
    }
    @FXML
    private void handlePartModifyBTN(ActionEvent event)throws IOExpception, IOException
    {
        Parent partModifyScreenParent = FXMLLoader.load(getClass().getResource("IMSPartsModifyScreen.fxml"));
        Scene partModifyScreenScene = new Scene (partModifyScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(partModifyScreenScene);
        window.show();
    }
    
    @FXML
    private void handleProductAddBTN(ActionEvent event)throws IOExpception, IOException
    {
        Parent productAddScreenParent = FXMLLoader.load(getClass().getResource("IMSProductAddScreen.fxml"));
        Scene productAddScreenScene = new Scene (productAddScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(productAddScreenScene);
        window.show();
    }
    @FXML
    private void handleProductModifyBTN(ActionEvent event)throws IOExpception, IOException
    {
        Parent productModifyScreenParent = FXMLLoader.load(getClass().getResource("IMSProductModifyScreen.fxml"));
        Scene productModifyScreenScene = new Scene (productModifyScreenParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(productModifyScreenScene);
        window.show();
    }
    @FXML
    private void handleExitBTN(ActionEvent event)
    {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    
}
