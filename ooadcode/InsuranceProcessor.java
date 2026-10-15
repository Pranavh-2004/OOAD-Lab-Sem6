public class InsuranceProcessor {
    public void verifyCoverage(Patient patient) {
        System.out.println("Insurance verified for " + patient.getName());
    }

    public void processClaim(Patient patient) {
        System.out.println("Claim processed for " + patient.getName());
    }
}