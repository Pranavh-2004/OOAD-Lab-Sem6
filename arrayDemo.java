import java.util.Arrays;

class ArrayDemo {
    public static void main(String[] args) {
        int[] marks = {85, 90, 78, 92};
        System.out.println("First element: " + marks[0]);
        System.out.println("Size: " + marks.length);
        System.out.println(marks);
        System.out.println("Array content: " + Arrays.toString(marks));
        System.out.println("All elements: ");
        for (int i = 0; i < marks.length; i++){
            System.out.print(marks[i]+ " ");
        }
        System.out.println();
    }    
}
