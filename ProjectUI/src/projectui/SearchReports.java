package projectui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by michaelbeavis on 26/10/2016.
 */
public class SearchReports {

    ArrayList reportDetails = new ArrayList();

    public void searchReportsByStatus(String status) throws SQLException {
        MySQLController conn = new MySQLController();
        ResultSet rs =  conn.searchDetailsByStatus(status);

        while (rs.next()) {
            BugReportDetails temp = new BugReportDetails(rs);
            reportDetails.add(temp);

        }
    }
}
