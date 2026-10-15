// The model part

class Patient 
{
    private String patientID;
    private String name;
    private String diagnosis;

    // Getters and Setters
    public String getPatientID() 
    { 
        return patientID; 
   }
    public void setPatientID(String patientID) 
    { 
        this.patientID = patientID; 
    }
    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }
    public String getDiagnosis() 
    { 
        return diagnosis; 
    }
    public void setDiagnosis(String diagnosis) 
    { 
        this.diagnosis = diagnosis; 
    }
}

// The view part
class PatientView 
{
    public void displayPatientRecord(String name, String id, String diagnosis) 
    {
        System.out.println("--- Hospital Medical Record ---");
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Current Diagnosis: " + diagnosis);
        System.out.println("-------------------------------");
    }
}

// The controller part
class PatientController 
{
    private Patient model;
    private PatientView view;

    public PatientController(Patient model, PatientView view) 
    {
        this.model = model;
        this.view = view;
    }

    // Update Model data
    public void setPatientDiagnosis(String diagnosis) 
    {
        model.setDiagnosis(diagnosis);
    }

    // Refresh the View
    public void updateView() 
    {
        view.displayPatientRecord(model.getName(), 
				model.getPatientID(), model.getDiagnosis());
    }
}

// The main program
public class HealthcareApp 
{
    public static void main(String[] args) 
    {
        // Initialize data
        Patient patient = new Patient();
        patient.setName("ABCD");
        patient.setPatientID("HOSP-789");
        patient.setDiagnosis("Stable");

        PatientView view = new PatientView();
        PatientController controller = new PatientController(patient, view);

        // Display initial record
        controller.updateView();

        // Update diagnosis via controller
        controller.setPatientDiagnosis("Recovering - Follow-up in 2 weeks");
        controller.updateView();
    }
}

