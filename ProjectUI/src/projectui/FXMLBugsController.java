/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
public class FXMLBugsController implements Initializable {
    
    CurrentUser currentUser;
    
    public FXMLBugsController (CurrentUser curr){
        currentUser = curr;
    }
    
    ObservableList<String> searchbyList = FXCollections.observableArrayList("Search By", "User","BugStatus","Priority");
    ObservableList<String> priorityList = FXCollections.observableArrayList("Select", "Low", "Medium", "High", "Emergency");
    ObservableList<String> statusList = FXCollections.observableArrayList("Select", "Reported","Progressing","Solved");
    ObservableList<String> severityList = FXCollections.observableArrayList("Select", "Critical","Major","Minor", "Cosmetic");
    
    ////////////////////////////////
    //Tabs
    ///////////////////////////////
//    @FXML
//    private TabPane createBugTab;
    ////////////////////////////////
    //Search Fields
    ///////////////////////////////
    @FXML
    private TextField searchBox;
    @FXML
    private ChoiceBox<String> searchBy;
    @FXML
    private Button searchButton;
    
    ////////////////////////////////
    //Search Bugs
    ///////////////////////////////
    @FXML
    private TableView<BugReportDetails> tablebugSearch;
    @FXML
    private TableColumn<?, ?> tablebugUser;
    @FXML
    private TableColumn<?, ?> tableuserName;
    @FXML
    private TableColumn<BugReportDetails, String> tableshortDesc;
    @FXML
    private TableColumn<BugReportDetails, String> tablebStatus;
    @FXML
    private TableColumn<BugReportDetails, String> tablePriority;
    @FXML
    private TableColumn<BugReportDetails, String> tableDate;
    
    ////////////////////////////////
    //Bug Details
    ///////////////////////////////
    @FXML
    private TextArea selectedbugDesc;
    @FXML
    private TextArea selectedbugReso;
    @FXML
    private Text selectedBugName;
    @FXML
    private Text selectedBugID;
    @FXML
    private Text selectedStatus;
    @FXML
    private Text selectedPriority;
    @FXML
    private Text selectedDate;
    @FXML
    private Text selectedReporter;
    @FXML
    private Text selectedProduct;
    @FXML
    private Text selectedOS;
    @FXML
    private Text selectedCmpnt;
    @FXML
    private Text selectedVer;
    @FXML
    private Text selectSev;
    @FXML
    private Text selectedAssign;
    
    ////////////////////////////////
    //Edit Bugs
    ///////////////////////////////
    @FXML
    private Button editButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField productBox;
    @FXML
    private TextField bugNamebox;
    @FXML
    private TextField versionBox;
    @FXML
    private TextField assignedBox;
    @FXML
    private TextField cmpntBox;
    @FXML
    private TextField osBox;
    @FXML
    private ChoiceBox<String> statusBox;
    @FXML
    private ChoiceBox<String> priorityBox;
    @FXML
    private ChoiceBox<String> severityBox;
    @FXML
    private Button increaseRepButton;
    @FXML
    private Button decreaseRepButton;
    @FXML
    private Button addCommentButton;
    @FXML
    private Button submitCommentButton;
    @FXML
    private Button uploadPatchButton;
    @FXML
    private Text repLevel;
    
    
    ////////////////////////////////
    //Create Bugs
    ///////////////////////////////
    @FXML
    private TextArea newDesc;
    @FXML
    private TextArea newKeywords;
    @FXML
    private TextField newBugName;
    @FXML
    private TextField newProductname;
    @FXML
    private TextField newVersionName;
    @FXML
    private TextField newComponentname;
    @FXML
    private TextField newOSName;
    @FXML
    private TextField NewAssignedName;
    @FXML
    private ChoiceBox<String> newSeverity;
    @FXML
    private ChoiceBox<String> newPriority;
    @FXML
    private ChoiceBox<String> newStatus;
    @FXML
    private Button backButton;
    
    ////////////////////////////////
    //Comments
    ///////////////////////////////
    @FXML
    private TableView<?> selectedCmnt;
    @FXML
    private TableColumn<?, ?> selectedUsercmnt;
    @FXML
    private TableColumn<?, ?> selectedDatecmnt;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        searchBy.setValue("Search By");
        searchBy.setItems(searchbyList);
        
        statusBox.setValue("Select");
        statusBox.setItems(statusList);
        
        priorityBox.setValue("Select");
        priorityBox.setItems(priorityList);
        
        severityBox.setValue("Select");
        severityBox.setItems(severityList);
        
        newStatus.setValue("Select");
        newStatus.setItems(statusList);
        
        newPriority.setValue("Select");
        newPriority.setItems(priorityList);
        
        newSeverity.setValue("Select");
        newSeverity.setItems(severityList);
        
        //CHECK SECURITY LEVEL IF USER IS UNAUTHENTICATED DISABLE CREATE BUG TAB
        //createBugTab.setDisable(true);
        
        //make the following visible to reporter and up
        editButton.setVisible(true);
        saveButton.setVisible(true);
        increaseRepButton.setVisible(true);
        decreaseRepButton.setVisible(true);
        addCommentButton.setVisible(true);
        submitCommentButton.setVisible(true);
        
        //dev and up
        uploadPatchButton.setVisible(true);
        
        
    }    

    @FXML
    private void searchBugs(ActionEvent event) throws SQLException {
        SearchReports reports = new SearchReports();

        reports.searchReportsByStatus("Reported");

        System.out.println("SEARCHING");
        
        //Access DB and search bugs
        //Once search completed populate the table
        
        //https://www.youtube.com/watch?v=UKzx4NRaZyM
        //New class will need to be created with results from search
        //Then the ?,? imn table view will need to be changed to Object, Variable
        //EG TableColumn<Bug, String> tableuserName;
        
        
        
        
    }

    @FXML
    private void bugSelected(MouseEvent event) {
        
        //once bug searched and selected on table
        //populate extended bug details
    }

    @FXML
    private void editBugDetails(ActionEvent event) {

        System.out.println("Edit Button Pressed");
        //On button press hides uneditable text
        selectedbugDesc.setEditable(true);
        selectedbugReso.setEditable(true);
        selectedBugName.setVisible(false);
        selectedStatus.setVisible(false);
        selectedPriority.setVisible(false);
        selectedProduct.setVisible(false);
        selectedOS.setVisible(false);
        selectedCmpnt.setVisible(false);
        selectedVer.setVisible(false);
        selectSev.setVisible(false);
        selectedAssign.setVisible(false);
        
        //Show editable fields
        
        
        
        productBox.setVisible(true);   
        bugNamebox.setVisible(true);  
        versionBox.setVisible(true);  
        assignedBox.setVisible(true);    
        cmpntBox.setVisible(true);    
        osBox.setVisible(true);    
        statusBox.setVisible(true);   
        priorityBox.setVisible(true);   
        severityBox.setVisible(true);
        
        productBox.setEditable(true);
        bugNamebox.setEditable(true);
        versionBox.setEditable(true);
        assignedBox.setEditable(true);    
        cmpntBox.setEditable(true);   
        osBox.setEditable(true); 
        
        // need to fill editable fields with current data from database
        //if none show empty
        
        
        
        
    }

    @FXML
    private void saveBugDetails(ActionEvent event) {
        
        //update fields to database
        
        //reveal non editable fields
        selectedbugDesc.setEditable(false);
        selectedbugReso.setEditable(false);
        selectedBugName.setVisible(true);
        selectedStatus.setVisible(true);
        selectedPriority.setVisible(true);
        selectedProduct.setVisible(true);
        selectedOS.setVisible(true);
        selectedCmpnt.setVisible(true);
        selectedVer.setVisible(true);
        selectSev.setVisible(true);
        selectedAssign.setVisible(true);
        
        //make editable fields invisible and disabled
        productBox.setVisible(false);   
        bugNamebox.setVisible(false);  
        versionBox.setVisible(false);  
        assignedBox.setVisible(false);    
        cmpntBox.setVisible(false);    
        osBox.setVisible(false);    
        statusBox.setVisible(false);   
        priorityBox.setVisible(false);   
        severityBox.setVisible(false);
        
        productBox.setEditable(false);
        bugNamebox.setEditable(false);
        versionBox.setEditable(false);
        assignedBox.setEditable(false);    
        cmpntBox.setEditable(false);   
        osBox.setEditable(false); 
        
    }
    
    @FXML
    private void backtoMenu(ActionEvent event) throws IOException {

        System.out.println("BACK TO MENU");

        switch(currentUser.getSecLevel()){
            case 1:
            {
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                FXMLMenuController controller = new FXMLMenuController(currentUser);
                loader.setController(controller);
                Parent menuPage_parent = loader.load();
                Scene menuPage_scene = new Scene(menuPage_parent);
                //takes to menu.
                app_stage.hide();
                app_stage.setScene(menuPage_scene);
                app_stage.show();
            }
            case 2:
            {
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
    }
    
    @FXML
    private void submitnewBug(ActionEvent event) {
        
        //take all variables from the table and save into DB
        
    }
    
    @FXML
    private void addComment(ActionEvent event) {
        
        //adds an editable row into already existing content of the comment table
        //allows edit in said row
        
    }
    
    @FXML
    private void submitComment(ActionEvent event) {
        
        //take all variables from the table and save into DB
        //takes last row added and adds it to the db as a new comment
    }
    
    @FXML
    private void uploadPatch(ActionEvent event) {
        
        //opens new window to upload patch? How?
        
    }
    
    @FXML
    private void decreaseRep(ActionEvent event) {
        
        //obvious decrease rep. After 1 press disable both the button
        
    }
    
    @FXML
    private void increaseRep(ActionEvent event) {
        
        //obvious increase rep. After 1 press disable both the button
        
    }
    
}
