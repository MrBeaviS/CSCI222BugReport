package projectui;

import java.sql.ResultSet;

/**
 * Created by michaelbeavis on 18/10/2016.
 */
public class CurrentUser {

    String username;
    String fullName;
    String email;
    String dateJoined;
    int secLevel;
    int repLevel;
    int numReports;

    CurrentUser(){}

    public void setDetails(ResultSet rs) {


    }


    public void setFullName(String FName, String LName){
        fullName = FName + " " + LName;
    }
    public void setEmail(String newEmail){
        email = newEmail;
    }
    public void setUsername(String uName){
        username = uName;
    }
    public void setdateJoined(String newDate){
        dateJoined = newDate;
    }
    public void setSecLevel(int newLevel){
        secLevel = newLevel;
    }
    public void setrepLevel(int newRep){
        repLevel = newRep;
    }
    public void setnumReports(int nReports){
        numReports = nReports;
    }


    public String getEmail(){
        return email;
    }
    public String getfullName(){
        return fullName;
    }
    public String getdateJoined(){
        return dateJoined;
    }
    public String getUsername(){
        return username;
    }
    public int getsecLevel(){
        return secLevel;
    }
    public int getrepLevel(){
        return repLevel;
    }
    public int getnumReports(){
        return numReports;
    }
}
