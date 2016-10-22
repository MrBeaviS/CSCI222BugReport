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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLAdminCreateUserController implements Initializable {

    CurrentUser currentUser;
    
    public FXMLAdminCreateUserController (CurrentUser curr){
        currentUser = curr;
    }
    
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newEmail;
    @FXML
    private TextField newFname;
    @FXML
    private TextField newLname;
    @FXML
    private Label errUserTaken;
    @FXML
    private Label errEmailTaken;
    @FXML
    private Button newRegister;
    @FXML
    private Button backtoLog;
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField setAccesslevel;
    @FXML
    private Text inputError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerAcc(ActionEvent event) {
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAuthMenu.fxml"));
        FXMLAuthMenuController controller = new FXMLAuthMenuController(currentUser);
        loader.setController(controller);
        Parent menuPage_parent = loader.load();
        Scene menuPage_scene = new Scene(menuPage_parent);
        app_stage.hide();
        app_stage.setScene(menuPage_scene);
        app_stage.show();
    }
    
}
