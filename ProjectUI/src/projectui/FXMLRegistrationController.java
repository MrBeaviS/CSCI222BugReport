/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLRegistrationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button backtoLog;
    
    @FXML
    private Button newRegister;
    
    @FXML
    //function for back button
    private void backAction(ActionEvent event) throws IOException
    {
        
        Parent loginPage_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene loginPage_scene = new Scene(loginPage_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(loginPage_scene);
        app_stage.show();
        
    }
    
    
    @FXML
    //function for registering new acc.
    private void registerAcc(ActionEvent event) throws IOException
    {
        
        //On Register button execute 
        //Take data and insert into table
        
        //Textfields need to be validated before entering.
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
