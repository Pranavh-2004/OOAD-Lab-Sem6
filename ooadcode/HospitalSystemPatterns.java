interface Patient {
    void register();
}

class Inpatient implements Patient {
    @Override
    public void register() {
        System.out.println("Registering Inpatient with admission details.");
    }
}

class Outpatient implements Patient {
    @Override
    public void register() {
        System.out.println("Registering Outpatient for consultation.");
    }
}

class EmergencyPatient implements Patient {
    @Override
    public void register() {
        System.out.println("Registering Emergency Patient with priority care.");
    }
}

class PatientFactory {
    public static Patient getPatient(String type) {
        switch(type.toLowerCase()) {
            case "inpatient":
                return new Inpatient();
            case "outpatient":
                return new Outpatient();
            case "emergency":
                return new EmergencyPatient();
            default:
                throw new IllegalArgumentException("Unknown patient type: " + type);
        }
    }
}

public class HospitalSystemPatterns {
    public static void main(String[] args) {
// When you declare a variable with an interface type, the variable can 
// hold a reference to any object whose class implements that interface
        Patient p1 = PatientFactory.getPatient("inpatient");
        p1.register();

        Patient p2 = PatientFactory.getPatient("outpatient");
        p2.register();

        Patient p3 = PatientFactory.getPatient("emergency");
        p3.register();
    }
}