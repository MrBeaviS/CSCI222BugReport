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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLGenerateReportController implements Initializable {

    CurrentUser currentUser;
    
    public FXMLGenerateReportController (CurrentUser curr){
        currentUser = curr;
    }
    
    @FXML
    private ChoiceBox<String> bugReportBox;
    @FXML
    private Button bugReportButton;
    @FXML
    private  ChoiceBox<String> useReportBox;
    @FXML
    private Button userReportButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generateBugReport(ActionEvent event) {
        
        //reports per week, month year etc.
    }

    @FXML
    private void generateUserReport(ActionEvent event) {
        //reports per week, month year etc.
    }
    
    @FXML
    private void backtoMenu(ActionEvent event) throws IOException {
        
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
