package projectui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michaelbeavis on 26/10/2016.
 */
public class SearchReports {

    private ObservableList<BugReportDetails> reportDetails = FXCollections.observableArrayList();

    public void searchReportsByStatus(String status) throws SQLException {
        MySQLController conn = new MySQLController();
        ResultSet rs =  conn.searchDetailsByStatus(status);

        while (rs.next()) {
            BugReportDetails temp = new BugReportDetails(rs);
            reportDetails.add(temp);

        }
    }

    public ObservableList<BugReportDetails> getReportDetails(){return reportDetails;}
}
