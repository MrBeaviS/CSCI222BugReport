/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLAuthMenuController implements Initializable {

    
    CurrentUser currentUser;
    
    public FXMLAuthMenuController (CurrentUser curr){
        currentUser = curr;
    }
    
    @FXML
    private Button vieweditProfile;
    @FXML
    private Button searchcommentBugs;
    @FXML
    private Button logoutButton;
    @FXML
    private Button generateReports;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vieweditProfileAction(ActionEvent event) throws IOException {
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLViewEditProfile.fxml"));
        FXMLViewEditProfileController controller = new FXMLViewEditProfileController(currentUser);
        loader.setController(controller);
        Parent menuPage_parent = loader.load();
        Scene menuPage_scene = new Scene(menuPage_parent);

        app_stage.hide();
        app_stage.setScene(menuPage_scene);
        app_stage.show();
        
    }

    @FXML
    private void searhcommentBugsAction(ActionEvent event) throws IOException {

        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLBugs.fxml"));
        FXMLBugsController controller = new FXMLBugsController(currentUser);
        loader.setController(controller);
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        app_stage.hide();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void logoutAction(ActionEvent event) {
    }

    @FXML
    private void generateReportAction(ActionEvent event) {
    }
    
}
