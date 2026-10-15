public class Patient {
    private String name;
    private String dob;
    private String insuranceInfo;

    public Patient(String name, String dob, String insuranceInfo) {
        this.name = name;
        this.dob = dob;
        this.insuranceInfo = insuranceInfo;
    }

    public String getName() {
        return name;
    }

    public int calculateAge() {
        return 2026 - Integer.parseInt(dob.substring(0, 4)); // Simplified
    }
}