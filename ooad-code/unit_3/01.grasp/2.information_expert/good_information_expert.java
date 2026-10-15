class Student {
    private int marks[];

    public Student(int marks[]) {
        this.marks = marks;
    }

    // Good design:
    // The responsibility of calculating the average should be given to the student because it has
    // the information of the marks of the student
    public double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total / (double) marks.length;
    }
}

class GoodInformationExpert {
    public static void main(String args[]) {
        Student student = new Student(new int[]{80, 90, 100});
        System.out.println("Average = " + student.calculateAverage());
    }
}
