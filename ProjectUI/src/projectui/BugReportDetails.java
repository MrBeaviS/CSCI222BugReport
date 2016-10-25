package projectui;

import javafx.beans.property.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michaelbeavis on 25/10/2016.
 */
public class BugReportDetails {
    //From Bug Table
    private final StringProperty bugId;
    private final StringProperty bugName;
    private final StringProperty product;
    private final StringProperty component;
    private final StringProperty version;
    private final StringProperty operatingSys;

    //From BugReports Table
    private final StringProperty bugReportId;
    private final StringProperty createdDate;
    private final StringProperty shortDesc;
    private final StringProperty bugStatus;
    private final StringProperty resolution;
    private final StringProperty priority;
    private final StringProperty bugSeverity;

    public BugReportDetails(ResultSet rs) throws SQLException {
        this.bugId = new SimpleStringProperty(rs.getString(1));
        this.bugName = new SimpleStringProperty(rs.getString(2));
        this.product = new SimpleStringProperty(rs.getString(3));
        this.component = new SimpleStringProperty(rs.getString(4));
        this.version = new SimpleStringProperty(rs.getString(5));
        this.operatingSys = new SimpleStringProperty(rs.getString(6));

        this.bugReportId = new SimpleStringProperty(rs.getString(7));
        this.createdDate = new SimpleStringProperty(rs.getString(8));
        this.shortDesc = new SimpleStringProperty(rs.getString(9));
        this.bugStatus = new SimpleStringProperty(rs.getString(12));
        this.resolution = new SimpleStringProperty(rs.getString(13));
        this.priority = new SimpleStringProperty(rs.getString(15));
        this.bugSeverity = new SimpleStringProperty(rs.getString(16));

    }

    //BugReport

    //BugReportDetails getters
    public String getBugId(){return bugId.get();}
    public String getBugName(){return bugName.get();}
    public String getProduct(){return product.get();}
    public String getComponent(){return component.get();}
    public String getVersion(){return version.get();}
    public String getOperatingSys(){return operatingSys.get();}
    public String getBugReportId(){return bugReportId.get();}
    public String getCreatedDate(){return createdDate.get();}
    public String getShortDesc(){return shortDesc.get();}
    public String getBugStatus(){return bugStatus.get();}
    public String getResolution(){return resolution.get();}
    public String getPriority(){return priority.get();}
    public String getBugSeverity(){return bugSeverity.get();}

}
