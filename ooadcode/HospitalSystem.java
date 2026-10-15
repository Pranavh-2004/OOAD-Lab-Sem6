// Abstract Superclass
abstract class HealthProfessional 
{
    protected String name;
    protected String specialization;

    public HealthProfessional(String name, String specialization) 
    {
        this.name = name;
        this.specialization = specialization;
    }

    // Abstract method: Every professional has a duty, but the details differ
    public abstract void performDuty();

    // Concrete method: All professionals follow a standard check-in process
    public void checkIn() 
    {
        System.out.println(name + " (" + specialization + ") has checked into the hospital.");
    }
}

// Concrete Subclass 1
class Doctor extends HealthProfessional 
{
    public Doctor(String name, String specialization) 
    {
        super(name, specialization);
    }

    @Override
    public void performDuty() {
        System.out.println(name + " is conducting general ward rounds and checking vitals.");
    }
}

// Concrete Subclass 2
class Surgeon extends HealthProfessional 
{
    public Surgeon(String name, String specialization) 
    {
        super(name, specialization);
    }

    @Override
    public void performDuty() 
    {
        System.out.println(name + " is performing a scheduled surgery in the OR.");
    }
}

public class HospitalSystem 
{
    public static void main(String[] args) 
    {
        // You cannot do: HealthProfessional hp = new HealthProfessional();

        HealthProfessional doc = new Doctor("Dr. Surya", "General Medicine");
        HealthProfessional srg = new Surgeon("Dr. Chandra", "Cardiothoracic");

        doc.checkIn();
        doc.performDuty();

        System.out.println("---------------------------");

        srg.checkIn();
        srg.performDuty();
    }
}
