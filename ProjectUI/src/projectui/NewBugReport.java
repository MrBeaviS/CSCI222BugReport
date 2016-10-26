package projectui;

/**
 * Created by michaelbeavis on 26/10/2016.
 */
public class NewBugReport {

    //Bug Table
    private String bugName;
    private String product;
    private String component;
    private String version;
    private String operSys;

    //BugReport Table
    //private String shortDesc; //no field for this
    private String bugStatus;
    private String keywords;
    private String priority;
    private String bugSev;
    private String longDesc;
    private String assigned;

    public void submitReport(){
        MySQLController conn = new MySQLController();
        conn.submitReport(this);
    }

    //NewBugReport class setters

    public void setBugName(String bugName){this.bugName = bugName;}
    public void setProduct(String product){this.product = product;}
    public void setComponent(String component){this.component = component;}
    public void setVersion(String version){this.version = version;}
    public void setOperSys(String operSys){this.operSys = operSys;}
    public void setBugStatus(String bugStatus){this.bugStatus = bugStatus;}
    public void setKeywords(String keywords){this.keywords = keywords;}
    public void setPriority(String priority){this.priority = priority;}
    public void setBugSev(String bugSev){this.bugSev = bugSev;}
    public void setLongDesc(String longDesc){this.longDesc = longDesc;}
    public void setAssigned(String assigned){this.assigned = assigned;}

    //NewBugReport class getters
    public String getBugName(){return bugName;}
    public String getProduct(){return product;}
    public String getComponent(){return component;}
    public String getVersion() {return version;}
    public String getOperSys() {return operSys;}
    public String getBugStatus(){return bugStatus;}
    public String getKeywords(){return keywords;}
    public String getPriority(){return priority;}
    public String getBugSev(){return bugSev;}
    public String getLongDesc(){return longDesc;}
    public String getAssigned(){return assigned;}
}
