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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLViewAdminProfileController implements Initializable {

    CurrentUser currentUser;
    CurrentUser searchUser;
    
    public  FXMLViewAdminProfileController (CurrentUser curr){
        currentUser = curr;
    }

    @FXML
    private Button backToMenu;
    @FXML
    private Button saveChangesButton;
    @FXML
    private Text currRep;
    @FXML
    private Text currNoReports;
    @FXML
    private Text dateJoined;
    @FXML
    private TextField firstNameBox;
    @FXML
    private TextField emailBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private TextField lastNameBox;
    @FXML
    private Text currUsername;
    @FXML
    private PasswordField newPassword;
    @FXML
    private Text errorText;
    @FXML
    private PasswordField accessLevelBox;
    @FXML
    private TextField searchField;
    @FXML
    private Button increaseRepButton;
    @FXML
    private Button decreaseRepbutton;
    @FXML
    private Button deleteProfileButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        currUsername.setText("");
        currRep.setText("");
        currNoReports.setText("");
        dateJoined.setText("");
        errorText.setText("");
    }    

    @FXML
    private void backtoMenu(ActionEvent event) throws IOException {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAuthMenu.fxml"));
        FXMLAuthMenuController controller = new FXMLAuthMenuController(currentUser);
        loader.setController(controller);
        Parent menuPage_parent = loader.load();
        Scene menuPage_scene = new Scene(menuPage_parent);
            
        //takes to menu.
        app_stage.hide();
        app_stage.setScene(menuPage_scene);
        app_stage.show();
    }

    @FXML
    private void saveChanges(ActionEvent event) throws SQLException {
        System.out.println("Saving Changes");
        if(newPassword.getText().isEmpty()){
            searchUser.updateUserNoP(firstNameBox.getText(), lastNameBox.getText(), emailBox.getText());
            errorText.setText("Changes Saved");
        } else {
            searchUser.updateUser(firstNameBox.getText(), lastNameBox.getText(), emailBox.getText(), newPassword.getText());
            errorText.setText("Changes Saved");
        }
    }

    @FXML
    private void findUser(ActionEvent event) throws SQLException {
        System.out.println("Searching for User");
        //searches user and fills all the fields
        searchUser = new CurrentUser(searchField.getText());
        searchUser.searchUser();
        if(searchUser.getAccessLevel() == 0){
            errorText.setText("User Not Found");
        } else {
            currUsername.setText(searchUser.getUserName());
            firstNameBox.setText(searchUser.getfName());
            lastNameBox.setText(searchUser.getlName());
            emailBox.setText(searchUser.getEmail());
            accessLevelBox.setText(searchUser.determineAccessLevelStr());
            currRep.setText(searchUser.getUserRep());
            currNoReports.setText(""); //TO DO: Count a users reports
            dateJoined.setText(searchUser.getJoinDate());
        }
    }

    @FXML
    private void increaseRep(ActionEvent event) {
        //increases rep
    }

    @FXML
    private void decreaseRep(ActionEvent event) {
        //decreases rep
    }
    
    @FXML
    private void deleteProfile(ActionEvent event) {
        //delete current profile
        System.out.println("Deleting User");
        searchUser.deleteUser();
        errorText.setText("User Deleted");
        clearScreen();
    }

    private void clearScreen(){
        currUsername.setText("");
        currRep.setText("");
        currNoReports.setText("");
        dateJoined.setText("");
        //errorText.setText("");
        currUsername.setText("");
        firstNameBox.setText("");
        lastNameBox.setText("");
        emailBox.setText("");
        accessLevelBox.setText("");
        currRep.setText("");
        currNoReports.setText(""); //TO DO: Count a users reports
        dateJoined.setText("");
    }
    
}
