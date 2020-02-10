/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Views;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static java.awt.SystemColor.window;
import java.awt.event.WindowAdapter;
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
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOStage 

    }
    public void  ConfirmClose(ActionEvent event) throws IOException, IOException
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Cancle add part?");
        alert.setContentText("This Will Not Save");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Parent IMSMainScreenParent = FXMLLoader.load(getClass().getResource("InventoryMangementSystemMainScreen.fxml"));
            Scene IMSMainScreenScene = new Scene (IMSMainScreenParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(IMSMainScreenScene);
            window.show();
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
        private void handleAddBTN()
        {
           //ConfirmClose(CancleBTN.doclick());
        }

}

