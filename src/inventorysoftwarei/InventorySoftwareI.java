/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei;

import inventorysoftwarei.Model.InHousePart;
import inventorysoftwarei.Model.Inventory;
import inventorysoftwarei.Model.OutSourcedPart;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import inventorysoftwarei.Views.InventoryMangementSystemMainScreenController;


/**
 *
 * @author Djok
 */
public class InventorySoftwareI extends Application 
{
    Inventory inventory = new Inventory();


    @Override
    public void start(Stage stage) throws Exception 
    {
        
        //test data
        InHousePart TestPart1;
        OutSourcedPart TestPart2;
        TestPart1 = new InHousePart(1,10,1,5,10.00,"Test1",1);
        TestPart2 = new OutSourcedPart(2,20,2,10,20.00,"Test2","Flex");
        inventory.addPart(TestPart1);
        inventory.addPart(TestPart2);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventorysoftwarei/Views/InventoryMangementSystemMainScreen.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() 
        {
            @Override
            public void handle(WindowEvent event) 
            {
                if(!ConfirmClose())
                {
                    event.consume();
                }
                else
                {
                    event.consume();
                    stage.close();
                }
                   
            }
        });
        
        InventoryMangementSystemMainScreenController IMSMainScreen = loader.getController();
        IMSMainScreen.InventoryReceiver(inventory);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    public static boolean  ConfirmClose()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you wish to exit?");
        alert.setContentText("Unsaved data will be lost.");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
    
}
