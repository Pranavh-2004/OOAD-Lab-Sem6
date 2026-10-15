class Student {
    private int marks[];

    public Student(int marks[]) {
        this.marks = marks;
    }

    public int[] getMarks() { return marks; }
}

class BadInformationExpert {
    public static void main(String args[]) {
        Student student = new Student(new int[]{80, 90, 100});
        double avg = calculateAverage(student);
        System.out.println("Average = " + avg);
    }

    // Bad design:
    // The BadInformationExpert class does not have the information of marks, hence it should
    // not be responsible of calculating the average marks of the student
    private static double calculateAverage(Student student) {
        double total = 0;

        for (int mark : student.getMarks()) {
            total += mark;
        }

        return total / (double) student.getMarks().length;
    }
}
