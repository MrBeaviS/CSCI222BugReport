/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectui;

import java.sql.*;

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
    
//    public int getsecLevel(){
//        return currentUser.getsecLevel();
//    }
//    public int getrepLevel(){
//            return currentUser.getrepLevel();
//        }
//    public int getnumReports(){
//            return currentUser.getnumReports();
//        }
//
//    public String getUsername(){
//        return currentUser.getUsername();
//    }
//    public String getEmail(){
//            return currentUser.getEmail();
//        }
//    public String getfullName(){
//            return currentUser.getfullName();
//        }
//    public String getdateJoined(){
//            return currentUser.getdateJoined();
//        }

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
        return access;
        
    }

//    public void updateUser(String fName, String lName, String pWord, String Email){
//
//        currentUser.setEmail(Email);
//        currentUser.setFullName(fName, lName);
//        getConnection();
//
//        try{
//            PreparedStatement ps = conn.prepareStatement("UPDATE superuser SET Email = ?, FName = ?, LName = ?, Password = ? WHERE Username = ?");
//
//            ps.setString(1, Email);
//            ps.setString(2, fName);
//            ps.setString(3, lName);
//            ps.setString(4, pWord);
//            ps.setString(5, currentUser.getUsername());
//            ps.executeUpdate();
//            ps.close();
//
//            closeConnection();
//
//
//        } catch(Exception e){
//            System.out.println(e);
//            System.exit(0);
//        }
//
//    }
//    public String getPassword(){
//
//        getConnection();
//        String password = "";
//
//        try{
//
//
//
//            String SQLAccessor = "SELECT * FROM superuser WHERE Username = " + "'" + currentUser.getUsername() + "'";
//
//            ResultSet rs = stmt.executeQuery(SQLAccessor);
//            while(rs.next()){
//                password = rs.getString("PASSWORD");
//            }
//
//            closeConnection();
//            rs.close();
//
//        } catch(Exception e){
//            System.out.println(e);
//            System.exit(0);
//        }
//        return password;
//
//    }

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
    
}
