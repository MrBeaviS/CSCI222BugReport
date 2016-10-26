/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLAddCommentController implements Initializable {

    CurrentUser currentUser;
    
    public FXMLAddCommentController (CurrentUser curr){
        currentUser = curr;
    }
    
    @FXML
    private TextArea commentField;
    @FXML
    private Button submitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitNewComment(ActionEvent event) {
        
        //take current user and date and commentField and attach
        //to a new class and submit to database
        
       Stage cmmt_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       cmmt_stage.close();
        
    }
    
}
