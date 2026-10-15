import java.util.ArrayList;

class Student {
    String SRN;
    String name;

    Student(String SRN, String name) {
        this.SRN = SRN;
        this.name = name;
    }
}

class StudentList {
    public static void main(String args[]) {
        ArrayList<Student> student_list = new ArrayList<Student>();

        student_list.add(new Student("S1", "N1"));
        student_list.add(new Student("S2", "N2"));
        student_list.add(new Student("S3", "N3"));
        student_list.add(new Student("S4", "N4"));

        for (int i = 0; i < student_list.size(); i++) {
            System.out.println(student_list.get(i).SRN + " " + student_list.get(i).name);
        }
    }
}
