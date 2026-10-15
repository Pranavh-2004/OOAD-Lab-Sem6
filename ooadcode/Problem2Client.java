import java.util.ArrayList;
import java.util.List;

// Singleton Policy Manager
class PolicyManager {
   private static PolicyManager instance;

   private PolicyManager() {}

   public static synchronized PolicyManager getInstance() {
       if (instance == null) {
           instance = new PolicyManager();
       }
       return instance;
   }

   public boolean validateModuleCount(int count, boolean isCertification) {
       if (isCertification && count < 5) {
           System.out.println("Policy Warning: Certification courses usually require at least 5 modules.");
           return false;
       }
       return true;
   }

   public String getGradingPolicy(boolean isCertification) {
       return isCertification ? "Strict Grading (80% pass mark)" : "Standard Grading (50% pass mark)";
   }
}

// Product: Course
class Course {
   private String name;
   private List<String> modules = new ArrayList<>();
   private List<String> assignments = new ArrayList<>();
   private List<String> quizzes = new ArrayList<>();
   private String certification;
   private String gradingPolicy;

   public void setName(String name) { this.name = name; }
   public void addModule(String module) { this.modules.add(module); }
   public void addAssignment(String assignment) { this.assignments.add(assignment); }
   public void addQuiz(String quiz) { this.quizzes.add(quiz); }
   public void setCertification(String certification) { this.certification = certification; }
   public void setGradingPolicy(String policy) { this.gradingPolicy = policy; }

   public void showCourseDetails() {
       System.out.println("--- Course Details: " + name + " ---");
       System.out.println("Modules: " + modules.size());
       System.out.println("Assignments: " + assignments.size());
       System.out.println("Quizzes: " + quizzes.size());
       System.out.println("Certification: " + (certification != null ? certification : "None"));
       System.out.println("Grading Policy: " + gradingPolicy);
       System.out.println("----------------------------------------\n");
   }
}

// Abstract Builder
interface CourseBuilder {
   void buildName();
   void buildModules();
   void buildAssignments();
   void buildQuizzes();
   void buildCertification();
   void applyPolicies();
   Course getCourse();
}

// Concrete Builder 1: BasicCourseBuilder
class BasicCourseBuilder implements CourseBuilder {
   private Course course = new Course();
   private PolicyManager policyManager = PolicyManager.getInstance();

   @Override public void buildName() { course.setName("Basic Introduction to Programming"); }
   @Override public void buildModules() { course.addModule("Module 1"); course.addModule("Module 2"); }
   @Override public void buildAssignments() { course.addAssignment("Basic Coding Assignment"); }
   @Override public void buildQuizzes() { course.addQuiz("Multiple Choice Quiz"); }
   @Override public void buildCertification() { course.setCertification(null); }
  
   @Override
   public void applyPolicies() {
       course.setGradingPolicy(policyManager.getGradingPolicy(false));
   }
  
   @Override public Course getCourse() { return course; }
}

// Concrete Builder 2: CertificationCourseBuilder
class CertificationCourseBuilder implements CourseBuilder {
   private Course course = new Course();
   private PolicyManager policyManager = PolicyManager.getInstance();

   @Override public void buildName() { course.setName("Advanced Software Engineering Certification"); }
  
   @Override
   public void buildModules() {
       for(int i=1; i<=6; i++) course.addModule("Advanced Module " + i);
   }
  
   @Override public void buildAssignments() { course.addAssignment("Capstone Project"); }
   @Override public void buildQuizzes() { course.addQuiz("Comprehensive Exam"); }
   @Override public void buildCertification() { course.setCertification("Industry Recognized Certificate"); }
  
   @Override
   public void applyPolicies() {
       policyManager.validateModuleCount(6, true);
       course.setGradingPolicy(policyManager.getGradingPolicy(true));
   }
  
   @Override public Course getCourse() { return course; }
}

// Director
class CourseDirector {
   public Course constructCourse(CourseBuilder builder) {
       builder.buildName();
       builder.buildModules();
       builder.buildAssignments();
       builder.buildQuizzes();
       builder.buildCertification();
       builder.applyPolicies();
       return builder.getCourse();
   }
}

// Main Client Class
public class Problem2Client {
   public static void main(String[] args) {
       CourseDirector director = new CourseDirector();

       System.out.println("Building a Basic Course...");
       CourseBuilder basicBuilder = new BasicCourseBuilder();
       Course basicCourse = director.constructCourse(basicBuilder);
       basicCourse.showCourseDetails();

       System.out.println("Building a Certification Course...");
       CourseBuilder certBuilder = new CertificationCourseBuilder();
       Course certCourse = director.constructCourse(certBuilder);
       certCourse.showCourseDetails();
   }
}
