// Domain class
class Report {
    private String title;

    public Report(String title) {
        this.title = title;
    }

    public void showReport() {
        System.out.println("Report: " + title);
    }
}

// Correct Creator: ReportManager manages and creates Report objects
class ReportManager {
    public Report createReport(String title) {
        return new Report(title);
    }
}

public class CorrectDemo {
    public static void main(String[] args) {
        ReportManager manager = new ReportManager();

        // ReportManager is the proper Creator
        Report report = manager.createReport("Sales Report");
        report.showReport();
    }
}