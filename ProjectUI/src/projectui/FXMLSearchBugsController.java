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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FXMLSearchBugsController implements Initializable {

    @FXML
    private AnchorPane SearchTable;
    @FXML
    private TextField searchField;
    @FXML
    private ChoiceBox<?> searchBy;
    @FXML
    private ChoiceBox<?> sortBy;
    @FXML
    private Button backToMenu;
    @FXML
    private Button searchButton;
    @FXML
    private AnchorPane tableAnch;
    @FXML
    private Rectangle resultTable;
    @FXML
    private TableView<?> resTable;
    @FXML
    private TableColumn<?, ?> bugidCol;
    @FXML
    private TableColumn<?, ?> useridCol;
    @FXML
    private TableColumn<?, ?> assCol;
    @FXML
    private TableColumn<?, ?> priorityCol;
    @FXML
    private TableColumn<?, ?> statusCol;
    @FXML
    private Text selectedbugName;
    @FXML
    private Text selectedbugID;
    @FXML
    private Text selectedbugStatus;
    @FXML
    private Text selectedbugDate;
    @FXML
    private TextArea selectedbugDesc;
    @FXML
    private Text selectedbugPriority;
    @FXML
    private Text selectedbugReporter;
    @FXML
    private Text selectedbugAssigned;
    @FXML
    private TableColumn<?, ?> comUser;
    @FXML
    private TableColumn<?, ?> comComment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backtoMenu(ActionEvent event) throws IOException {
        //make sure security level is still set correctly
        Parent menuPage_parent = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        Scene menuPage_scene = new Scene(menuPage_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(menuPage_scene);
        app_stage.show();
    }
    @FXML
    private void searchBugReports(ActionEvent event) {
    
        //functions on execute go here. Eg fill table with
        //searched details

    }
    
}
