class Student {
    String srn;
    String name;

    Student(String srn, String name) {
        this.srn = srn;
        this.name = name;
    }

    public String toString() {
        return srn + "-" + name;
    }

    public boolean equals(Student other) {
        return (this.srn == other.srn) && (this.name == other.name);
    }

    public Student clone() {
        return new Student(this.srn, this.name);
    }
}

class ObjectClass {
    public static void main(String args[]) {
        Student s1 = new Student("10", "S1");
        Student s2 = new Student("10", "S1");
        Student s3 = s1;
        Student s4 = s1.clone();

        System.out.println("s1 = " + s1);
        System.out.println("s1.getClass = " + s1.getClass());
        System.out.println("s1.hashCode = " + s1.hashCode());
        System.out.println("s1 == s2 = " + (s1 == s2));
        System.out.println("s1 == s3 = " + (s1 == s3));
        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1.equals(s3) = " + s1.equals(s3));
        System.out.println("s4 == s1 = " + (s1 == s4));
    }
}
