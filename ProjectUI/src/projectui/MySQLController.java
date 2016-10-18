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

    CurrentUser currentUser = new CurrentUser();
    
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

        int access = 0;
        try{
            getConnection();

            String statement = "SELECT BugTrackerPrime.verifyLogIn(\'" + uName + "\' , \'" + pWord + "\')";

            ResultSet seclevel = stmt.executeQuery(statement);

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

    public void updateUser(String fName, String lName, String pWord, String Email){
        
        currentUser.setEmail(Email);
        currentUser.setFullName(fName, lName);
        getConnection();
        
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE superuser SET Email = ?, FName = ?, LName = ?, Password = ? WHERE Username = ?");
            
            ps.setString(1, Email);
            ps.setString(2, fName);
            ps.setString(3, lName);
            ps.setString(4, pWord);
            ps.setString(5, currentUser.getUsername());
            ps.executeUpdate();
            ps.close();

            closeConnection();

            
        } catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        
    }
    public String getPassword(){
        
        getConnection();
        String password = "";
        
        try{


            
            String SQLAccessor = "SELECT * FROM superuser WHERE Username = " + "'" + currentUser.getUsername() + "'";

            ResultSet rs = stmt.executeQuery(SQLAccessor);
            while(rs.next()){
                password = rs.getString("PASSWORD");
            }
            
            closeConnection();
            rs.close();

        } catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return password;

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
    
    
}
