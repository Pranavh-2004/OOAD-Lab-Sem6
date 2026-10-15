// 			ViolateCreator
class Report {
    private String title;

    public Report(String title) {
        this.title = title;
    }

    public void showReport() {
        System.out.println("Report: " + title);
    }
}

// ❌ Wrong Creator: DatabaseConnection is creating Report objects
class DatabaseConnection {
    public void connect() {
        System.out.println("Connected to database...");
    }

    // Violation: DatabaseConnection has no logical reason to create Report
    public Report createReport(String title) {
        return new Report(title);
    }
}

public class ViolationDemo {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.connect();

        // DatabaseConnection wrongly creates Report
        Report report = db.createReport("Sales Report");
        report.showReport();
    }
}