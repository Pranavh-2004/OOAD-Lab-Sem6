// Example: Healthcare Appointment Facade
// Scenario
// Subsystems: PatientService, DoctorService, AppointmentService
// Each has its own complexity.
// The Facade (HealthcareFacade) provides a simple method bookAppointment() that 
// hides the subsystem details.

// Subsystem classes

// Patient subsystem
class PatientService 
{
    public void registerPatient(String patientName) 
    {
        System.out.println("Patient registered: " + patientName);
    }
}

// Doctor subsystem
class DoctorService 
{
    public void assignDoctor(String doctorName) 
    {
        System.out.println("Doctor assigned: " + doctorName);
    }
}

// Appointment subsystem
class AppointmentService 
{
    public void scheduleAppointment(String date) 
    {
        System.out.println("Appointment scheduled on: " + date);
    }
}

// Facade class

// Facade class that simplifies subsystem usage
class HealthcareFacade 
{
    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;

    public HealthcareFacade() 
    {
        this.patientService = new PatientService();
        this.doctorService = new DoctorService();
        this.appointmentService = new AppointmentService();
    }

    public void bookAppointment(String patientName, String doctorName, String date) 
    {
        patientService.registerPatient(patientName);
        doctorService.assignDoctor(doctorName);
        appointmentService.scheduleAppointment(date);
        System.out.println("Appointment booking completed successfully!");
    }
}


// The client code
public class HealthcareSystem 
{
    public static void main(String[] args) 
    {
        HealthcareFacade facade = new HealthcareFacade();
        facade.bookAppointment("John Doe", "Dr. Smith", "2026-03-30");
    }
}