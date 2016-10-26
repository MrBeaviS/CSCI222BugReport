package projectui;

/**
 * Created by michaelbeavis on 26/10/2016.
 */
public class ReportStats {

    private int range; //this will determine week/monthly/half-year/year counts

    //bug report tallies
    private int newBugReports;
    private int reportsAssigned;
    private int reportsUnassigned;

    //bug status tallies
    private int reportedBugs;
    private int progressingBugs;
    private int solvedBugs;

    //bug priority tallies
    private int lowPriority;
    private int medPriority;
    private int highPriority;
    private int emergencyPriority;

    //bug severity tallies
    private int cosmeticSev;
    private int minorSev;
    private int majorSev;
    private int criticalSev;

    public ReportStats(int r) {
        range = r;

    }


    //ReportStats getters
    public int getNewBugReports(){return newBugReports;}
    public int getReportsAssigned(){return reportsAssigned;}
    public int getReportsUnassigned(){return reportsUnassigned;}
    public int getReportedBugs(){return reportedBugs;}
    public int getProgressingBugs(){return progressingBugs;}
    public int getSolvedBugs(){return solvedBugs;}
    public int getLowPriority(){return lowPriority;}
    public int getMedPriority(){return medPriority;}
    public int getHighPriority(){return highPriority;}
    public int getEmergencyPriority(){return emergencyPriority;}
    public int getCosmeticSev(){return cosmeticSev;}
    public int getMinorSev(){return minorSev;}
    public int getMajorSev(){return majorSev;}
    public int getCriticalSev(){return criticalSev;}
}
