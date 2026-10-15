// === Q1: ADAPTER PATTERN ===
// Target interface expected by the hospital system
interface HospitalReportSystem {
    String getPatientReport();
}

// Existing lab classes (Adaptees) - cannot be modified
class BloodLab {
    public String getBloodReport() {
        return "Blood Lab Report: Hemoglobin=13.5, WBC=7000, Platelets=250000";
    }
}

class DiagnosticsLab {
    public String fetchLabResults() {
        return "Diagnostics Lab Results: X-Ray=Normal, MRI=Clear";
    }
}

class PathologyLab {
    public String retrieveDiagnostics() {
        return "Pathology Report: Biopsy=Benign, Culture=Negative";
    }
}

// Adapters - wrap each lab to match HospitalReportSystem interface
class BloodLabAdapter implements HospitalReportSystem {
    private BloodLab bloodLab;

    public BloodLabAdapter(BloodLab bloodLab) {
        this.bloodLab = bloodLab;
    }

    @Override
    public String getPatientReport() {
        return "[ADAPTED] " + bloodLab.getBloodReport();
    }
}

class DiagnosticsLabAdapter implements HospitalReportSystem {
    private DiagnosticsLab diagnosticsLab;

    public DiagnosticsLabAdapter(DiagnosticsLab diagnosticsLab) {
        this.diagnosticsLab = diagnosticsLab;
    }

    @Override
    public String getPatientReport() {
        return "[ADAPTED] " + diagnosticsLab.fetchLabResults();
    }
}

class PathologyLabAdapter implements HospitalReportSystem {
    private PathologyLab pathologyLab;

    public PathologyLabAdapter(PathologyLab pathologyLab) {
        this.pathologyLab = pathologyLab;
    }

    @Override
    public String getPatientReport() {
        return "[ADAPTED] " + pathologyLab.retrieveDiagnostics();
    }
}

// Client - Hospital system uses only getPatientReport()
public class LabAdapter {
    public static void main(String[] args) {
        HospitalReportSystem[] labs = {
            new BloodLabAdapter(new BloodLab()),
            new DiagnosticsLabAdapter(new DiagnosticsLab()),
            new PathologyLabAdapter(new PathologyLab())
        };

        System.out.println("=== Hospital Patient Reports ===");
        for (HospitalReportSystem lab : labs) {
            System.out.println(lab.getPatientReport());
        }
    }
}
