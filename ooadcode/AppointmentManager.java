public class AppointmentManager {
    public void scheduleAppointment(Patient patient, Doctor doctor, String time) {
        if (doctor.isAvailable(time)) {
            Appointment appointment = new Appointment();
            appointment.schedule();
            System.out.println("Appointment scheduled for " + patient.getName() + " with Dr. " + doctor.getName());
        } else {
            System.out.println("Doctor not available at " + time);
        }
    }
}