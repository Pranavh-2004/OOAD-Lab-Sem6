class ObjectClass {
    public static void main(String[] args) {
        
        Student s1 = new Student(10, "S1");
        Student s2 = new Student(10, "S1");
        Student s3 = s1; // s3 references the same object as s1
       
        Student s4 = s1.clone(); // s4 is a clone of s1, a different object with the same content 
    }
}
