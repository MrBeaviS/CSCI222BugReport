package projectui;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michaelbeavis on 18/10/2016.
 */
public class CurrentUser {

    private int userID;
    private String userName;
    private String fName;
    private String lName;
    private String email;
    private String joinDate;
    private String userRep;
    private String accStatus;
    private String adminRole;
    private String newPass;
    private int accessLevel;

    CurrentUser(String uName){
        userName = uName;
    }

    public void setUserDetails() throws SQLException {

        MySQLController conn = new MySQLController();
        try{
            ResultSet rs = conn.setCurrentUser(this);
            System.out.println("Setting Current User");
            while (rs.next()) {
                userID = rs.getInt("UserID");
                userName = rs.getString("UserName");
                fName = rs.getString("FName");
                lName = rs.getString("Lname");
                email = rs.getString("Email");
                joinDate = rs.getString("JoinedDate");
                userRep = rs.getString("UserReputation");
                accStatus = rs.getString("AccountStatus");
                accessLevel = rs.getInt("AccessRights");

            }
//            printUser();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void setAdminDetails() throws SQLException {
        MySQLController conn = new MySQLController();
        try{
            ResultSet rs = conn.setCurrentAdmin(this);

            while (rs.next()) {
                userID = rs.getInt("UserID");
                userName = rs.getString("UserName");
                fName = rs.getString("FName");
                lName = rs.getString("Lname");
                email = rs.getString("Email");
                joinDate = rs.getString("JoinedDate");
                adminRole = rs.getString("Role");
                accessLevel = rs.getInt("AccessRights");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAdminNoP(String first, String last, String nEmail) throws SQLException {
        fName = first;
        lName = last;
        email = nEmail;
        MySQLController conn = new MySQLController();
        try{
            conn.updateAdminNoP(this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(String first, String last, String nEmail, String pass) throws SQLException {
        fName = first;
        lName = last;
        email = nEmail;
        newPass = pass;
        MySQLController conn = new MySQLController();
        try{
            conn.updateAdmin(this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserNoP(String first, String last, String nEmail) throws SQLException {
        fName = first;
        lName = last;
        email = nEmail;
        MySQLController conn = new MySQLController();
        try{
            conn.updateUserNoP(this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String first, String last, String nEmail, String pass) throws SQLException {
        fName = first;
        lName = last;
        email = nEmail;
        newPass = pass;
        MySQLController conn = new MySQLController();
        try{
            conn.updateUser(this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(){
        MySQLController conn = new MySQLController();
        try{
            conn.deleteUser(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void searchUser() throws SQLException {
        MySQLController conn = new MySQLController();

        try{
            ResultSet rs = conn.searchUser(this);
            if(rs == null){
                accessLevel = 0;
            } else {
                while (rs.next()) {
                    userName = rs.getString("UserName");
                    fName = rs.getString("FName");
                    lName = rs.getString("Lname");
                    email = rs.getString("Email");
                    joinDate = rs.getString("JoinedDate");
                    userRep = rs.getString("UserReputation");
                    accStatus = rs.getString("AccountStatus");
                    accessLevel = rs.getInt("AccessRights");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String determineAccessLevelStr(){
        switch (accessLevel){
            case 1:
                return "Reporter";
            case 2:
                return "Reviewer";
            case 3:
                return "Developer";
            case 4:
                return "Triage";
            case 5:
                return "Admin";
            default:
                return "No Role";
        }
    }




    public void setEmail(String newEmail){
        email = newEmail;
    }

    public int getUserID(){return userID;}
    public String getUserName(){return userName;}
    public String getfName(){return  fName;}
    public String getlName(){return lName;}
    public String getEmail(){return email;}
    public String getJoinDate(){return joinDate;}
    public String getUserRep(){return userRep;}
    public String getAccStatus(){return accStatus;}
    public String getAdminRole(){return adminRole;}
    public String getNewPass(){return newPass;}
    public int getAccessLevel(){return accessLevel;}

}

