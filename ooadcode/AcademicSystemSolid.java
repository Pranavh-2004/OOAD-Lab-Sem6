class Student {
    private String id;
    private String name;
    private String email;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Course {
    private String code;
    private String title;
    private int credits;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
}

interface Enrollable {
    void enroll(Student student, Course course);
}

interface Reportable {
    void generateReport();
}

interface GradingPolicy {
    String calculateGrade(double score);
}

class PercentageGrading implements GradingPolicy {
    @Override
    public String calculateGrade(double score) {
        if (score >= 90) return "A";
        else if (score >= 75) return "B";
        else if (score >= 60) return "C";
        else return "F";
    }
}

class GPAGrading implements GradingPolicy {
    @Override
    public String calculateGrade(double score) {
        if (score >= 90) return "4.0";
        else if (score >= 75) return "3.0";
        else if (score >= 60) return "2.0";
        else return "0.0";
    }
}

interface StudentRepository {
    void save(Student student);
    Student find(String id);
}

class InMemoryStudentRepository implements StudentRepository {
    private java.util.Map<String, Student> storage = new java.util.HashMap<>();

    @Override
    public void save(Student student) {
        storage.put(student.getId(), student);
    }

    @Override
    public Student find(String id) {
        return storage.get(id);
    }
}

class EnrollmentService implements Enrollable {
    @Override
    public void enroll(Student student, Course course) {
        System.out.println(student.getName() + " enrolled in " + course.getTitle());
    }
}

class AcademicService {
    private StudentRepository repository;
    private GradingPolicy gradingPolicy;
    private EnrollmentService enrollmentService;

    public AcademicService(StudentRepository repository, GradingPolicy gradingPolicy, EnrollmentService enrollmentService) {
        this.repository = repository;
        this.gradingPolicy = gradingPolicy;
        this.enrollmentService = enrollmentService;
    }

    public void registerStudent(Student student) {
        repository.save(student);
        System.out.println("Registered student: " + student.getName());
    }

    public void enrollStudent(String studentId, Course course) {
        Student student = repository.find(studentId);
        if (student != null) {
            enrollmentService.enroll(student, course);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void assignGrade(String studentId, double score) {
        Student student = repository.find(studentId);
        if (student != null) {
            String grade = gradingPolicy.calculateGrade(score);
            System.out.println("Assigned grade for " + student.getName() + ": " + grade);
        } else {
            System.out.println("Student not found!");
        }
    }
}

// --- Main Program ---
public class AcademicSystemSolid {
    public static void main(String[] args) {
        StudentRepository repo = new InMemoryStudentRepository();
        GradingPolicy grading = new PercentageGrading(); 
        EnrollmentService enrollment = new EnrollmentService();

        AcademicService service = new AcademicService(repo, grading, enrollment);

        Student s1 = new Student("S001", "Alice", "alice@university.edu");
        Student s2 = new Student("S002", "Bob", "bob@university.edu");

        Course c1 = new Course("CS101", "Intro to Programming", 4);
        Course c2 = new Course("MA201", "Discrete Mathematics", 3);

        service.registerStudent(s1);
        service.registerStudent(s2);

        service.enrollStudent("S001", c1);
        service.enrollStudent("S002", c2);

        service.assignGrade("S001", 85);
        service.assignGrade("S002", 92);
    }
}