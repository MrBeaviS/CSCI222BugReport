/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nathan
 */
public class MySQLController {

    //CurrentUser currentUser = new CurrentUser();
    
    String driver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/BugTrackerPrime";
    String dbUsername = "newUser";
    String dbPassword = "pass123";
    Statement stmt;
    Connection conn;
    

    public void getConnection(){
        try{
            
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            stmt = conn.createStatement();
            
        }catch(Exception e){
            
            System.out.println(e);
            System.exit(0);  
            
        }
    }
    public void closeConnection(){
        
        try{
            
            stmt.close();
            conn.close();
        
        } catch(Exception e){
         
            System.out.println(e);
            System.exit(0);
            
        }
    }
    public int loginDB(String uName, String pWord){
        getConnection();
        int access = 0;
        String sql = "SELECT BugTrackerPrime.verifyLogIn(\'" + uName + "\' , \'" + pWord + "\')";
        try{
            ResultSet seclevel = stmt.executeQuery(sql);
            while(seclevel.next()){
                access = seclevel.getInt(1);
            }
            closeConnection();
            seclevel.close();
        } catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        System.out.println("access : " + access);
        return access;
        
    }

    public void registerNewUser(NewUser newUser){

        getConnection();
        try{
            String statement = "CALL BugTrackerPrime.insertNewUser(\'" + newUser.getUserName() + "\', \'"  + newUser.getfName() + "\', \'" +
                    newUser.getlName() + "\', \'" +  newUser.getEmail() + "\', \'" + newUser.getPassWord() + "\')";
            //System.out.println(statement);
            stmt.executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    public void registerNewUserAdmin(NewUser newUser){

        getConnection();
        try{
            String statement = "CALL BugTrackerPrime.insertNewUserAdmin(\'" +newUser.getAccessLevel() + "\', \'"+ newUser.getUserName() + "\', \'"  + newUser.getfName() + "\', \'" +
                    newUser.getlName() + "\', \'" +  newUser.getEmail() + "\', \'" + newUser.getPassWord() + "\')";
            System.out.println(statement);
            stmt.executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    

    public ResultSet setCurrentUser(CurrentUser currUser) {
        getConnection();
        ResultSet rs = null;
        try {
            String sql = "CALL BugTrackerPrime.setCurrentUser(\'" + currUser.getUserName() + "\')";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet setCurrentAdmin(CurrentUser currUser) {
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.setCurrentAdmin(\'" + currUser.getUserName() + "\')";
            rs = stmt.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return rs;
    }

    public void updateAdminNoP(CurrentUser currUser){
        getConnection();
        try{
            String sql = "CALL BugTrackerPrime.updateAdminNoP(\'" + currUser.getUserName() + "\' , \'" +
                    currUser.getfName() + "\' , \'" + currUser.getlName() + "\' , \'" +
                    currUser.getEmail() + "\')";
            stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAdmin(CurrentUser currUser){
        getConnection();
        try{
            String sql = "CALL BugTrackerPrime.updateAdmin(\'" + currUser.getUserName() + "\' , \'" +
                    currUser.getfName() + "\' , \'" + currUser.getlName() + "\' , \'" +
                    currUser.getEmail() + "\' , \'" + currUser.getNewPass() + "\')";
            stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateUserNoP(CurrentUser currUser){
        getConnection();
        try{
            String sql = "CALL BugTrackerPrime.updateUserNoP(\'" + currUser.getUserName() + "\' , \'" +
                    currUser.getfName() + "\' , \'" + currUser.getlName() + "\' , \'" +
                    currUser.getEmail() + "\' , \'" + currUser.getUserRep() + "\')";
            stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateUser(CurrentUser currUser){
        getConnection();
        try{
            String sql = "CALL BugTrackerPrime.updateUser(\'" + currUser.getUserName() + "\' , \'" +
                    currUser.getfName() + "\' , \'" + currUser.getlName() + "\' , \'" +
                    currUser.getEmail() + "\' , \'" + currUser.getNewPass() + "\' , \'" + currUser.getUserRep()  + "\')";
            stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(CurrentUser curr){
        getConnection();;
        try{
            String sql = "CALL BugTrackerPrime.deleteUser(\'" + curr.getUserName() + "\')";
            stmt.executeQuery(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public ResultSet searchDetailsByStatus(String search){
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.setSearchDetailsByStatus(\'" + search + "\')";
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchDetailsByUser(String search){
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.setSearchDetailsByUser(\'" + search + "\')";
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchDetailsByPriority(String search){
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.setSearchDetailsByPriority(\'" + search + "\')";
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet populateExtDetails(int id){
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.populateExtReportDetails(" + id + ")";
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchUser(CurrentUser curr){
        getConnection();
        ResultSet rs = null;
        try {
            String sql = "CALL BugTrackerPrime.setCurrentUser(\'" + curr.getUserName() + "\')";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public boolean searchUser(String user){
        getConnection();
        ResultSet rs;
        try {
            String sql = "CALL BugTrackerPrime.setCurrentUser(\'" + user + "\')";
            rs = stmt.executeQuery(sql);
            if(rs == null){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
   
    /////////////////////////////NATHAN/////////////////////
     public ResultSet searchComments(int search){
        getConnection();
        ResultSet rs = null;
        try{
            String sql = "CALL BugTrackerPrime.setFindComments(\'" + search + "\')";
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
     public void registerNewComment(newBugComment nComment){

        getConnection();
        try{
            String statement = "CALL BugTrackerPrime.insertNewComment(\'" +nComment.getUserID() + "\', \'"+ nComment.getBugRepID() + "\', \'"  + nComment.getCommentText() + "\')";
            System.out.println(statement);
            stmt.executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        
    }

    //----------------------------- REPORT GEN FUNCTIONS -------------------------------//

    public ResultSet getNewBugReports (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.newBugReports(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getReportsAssigned (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countReportsAssigned(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getReportsUnassigned (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countReportsUnassigned(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getReportedBugs (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countReportedBugs(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getProgressingBugs (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countProgressBugs(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getSolvedBugs (int range) throws SQLException{
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countSolvedBugs(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getLowPriority (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countLowPriority(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getMedPriority (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countMedPriority(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getHighPriority (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countHighPriority(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getEmergencyPriority (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countEmergencyPriority(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getCosmeticSev (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countCosmeticSev(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getMinorSev (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countMinorSev(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getMajorSev (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countMajorSev(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.populate(rs);
        closeConnection();
        return res;
    }

    public ResultSet getCriticalSev (int range) throws SQLException {
        getConnection();
        ResultSet rs = null;
        CachedRowSet res = new CachedRowSetImpl();
        try {
            String sql = "CALL BugTrackerPrime.countCriticalSev(" + range + ")";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        res.populate(rs);
        closeConnection();
        return res;
    }

    public void submitReport(NewBugReport report) throws SQLException{
        getConnection();
        try {
            String sql = "CALL BugTrackerPrime.submitReport(\'" + report.getBugName() + "\' , \'" +
                    report.getProduct() + "\' , \'" + report.getComponent() + "\' , \'" +
                    report.getVersion() + "\' , \'" + report.getOperSys() + "\' , \'" +
                    report.getBugStatus() + "\' , \'" + report.getKeywords() + "\' , \'" +
                    report.getPriority() + "\' , \'" + report.getBugSev() + "\' , \'" +
                    report.getLongDesc() + "\' , \'" + report.getReporterID() + "\' ,\'" + report.getShortDesc() + "\')";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateReport(NewBugReport report) throws SQLException{
        getConnection();
        try {
            String sql = "CALL BugTrackerPrime.updateReport(\'" + report.getBugName() + "\' , \'" +
                    report.getProduct() + "\' , \'" + report.getComponent() + "\' , \'" +
                    report.getVersion() + "\' , \'" + report.getOperSys() + "\' , \'" +
                    report.getBugStatus() + "\' , \'" + report.getKeywords() + "\' , \'" +
                    report.getPriority() + "\' , \'" + report.getBugSev() + "\' , \'" +
                    report.getLongDesc() + "\' , \'" + report.getReporterID() + "\' , \'" +
                    report.getBugID() + "\' , \'" + report.getResolution() + "\' ,\'" + report.getAssigned() + "\' , \'" +
                    report.getUserRep() +"\')";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<String> getDevList(){
        getConnection();
        ResultSet rs = null;
        ObservableList<String> Devs = FXCollections.observableArrayList();
        try{
            String sql = "CALL BugTrackerPrime.getDevs()";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String temp = rs.getString(1);
                Devs.add(temp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return Devs;
    }
    

}
