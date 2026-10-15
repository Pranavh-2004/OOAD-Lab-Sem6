public class HospitalSystemG {
    public void login(String username, String password) {
        System.out.println("User logged in: " + username);
    }

    public void bookAppointment(Patient patient, Doctor doctor, String time) {
        AppointmentManager manager = new AppointmentManager();
        manager.scheduleAppointment(patient, doctor, time);
    }

    public void generateBill(Patient patient, String treatment) {
        Billing billing = new Billing();
        billing.calculateCharges(patient, treatment);
        billing.processPayment();
    }
}