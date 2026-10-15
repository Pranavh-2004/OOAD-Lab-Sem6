import java.util.ArrayList;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Anu");
        students.add("Ravi");
        students.add("Kiran");

        System.out.println("Students: " + students);
        students.remove("Ravi");

        System.out.println("After removal: " + students);
        System.out.println("Size: " + students.size());
        students.add(0, "Ramu");
        System.out.println("Students: " + students);
    }    
}
