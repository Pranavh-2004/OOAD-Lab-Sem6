// Interface defining a specialized academic role
interface Researcher 
{
    void publishPaper(String title);
    void attendConference();
}

// Abstract Superclass defining common academic identity
abstract class UniversityMember 
{
    protected String name;
    protected String memberId;

    public UniversityMember(String name, String memberId) 
    {
        this.name = name;
        this.memberId = memberId;
    }

    // Concrete method: Everyone must check in
    public void recordAttendance() 
    {
        System.out.println(name + " (ID: " + memberId + ") checked in at the university portal.");
    }

    // Abstract method: Different members have different daily tasks
    public abstract void performMainDuty();
}

// Concrete Subclass: Student (inherits from UniversityMember)
class Student extends UniversityMember 
{
    private String major;

    public Student(String name, String memberId, String major) 
    {
        super(name, memberId);
        this.major = major;
    }

    @Override
    public void performMainDuty() 
    {
        System.out.println(name + " is attending lectures for " + major + ".");
    }
}

// Concrete Subclass: Professor (inherits from UniversityMember AND 
// implements Researcher)
class Professor extends UniversityMember implements Researcher 
{
    private String department;

    public Professor(String name, String memberId, String department) 
    {
        super(name, memberId);
        this.department = department;
    }

    @Override
    public void performMainDuty() 
    {
        System.out.println(name + " is delivering a lecture in the " + department + " department.");
    }

    @Override
    public void publishPaper(String title) 
    {
        System.out.println("Professor " + name + " published: '" + title + "' in a peer-reviewed journal.");
    }

    @Override
    public void attendConference() 
    {
        System.out.println(name + " is presenting research at the International Academic Summit.");
    }
}

public class AcademicSystem 
{
    public static void main(String[] args) 
    {
        // Create a regular Student
        Student s1 = new Student("Surya", "S101", "Computer Science");
        s1.recordAttendance();
        s1.performMainDuty();

        System.out.println("------------------------------------");

        // Create a Professor who is also a Researcher
        Professor p1 = new Professor("Dr. Chandra", "P505", "Physics");
        p1.recordAttendance();
        p1.performMainDuty();
        
        // Polymorphism via Interface
        Researcher researcherRole = p1; 
        researcherRole.publishPaper("Quantum Mechanics in Modern Computing");
        researcherRole.attendConference();
    }
}
