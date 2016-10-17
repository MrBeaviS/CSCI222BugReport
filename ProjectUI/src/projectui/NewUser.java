package projectui;

/**
 * Created by michaelbeavis on 17/10/2016.
 */
public class NewUser {

    private String userName;
    private String fName;
    private String lName;
    private String email;
    private String passWord;



    public void setNewUser(String uName, String first, String last, String mail, String pWord){
        MySQLController DBConn = new MySQLController();
        userName = uName;
        fName = first;
        lName = last;
        email = mail;
        passWord = pWord;

        DBConn.registerNewUser(this);


    }

    public String getUserName(){return userName;}

    public String getfName() {return fName;}

    public String getlName() {return lName;}

    public String getEmail() {return email;}

    public String getPassWord() {return passWord;}
}
