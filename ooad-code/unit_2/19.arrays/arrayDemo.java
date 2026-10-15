import java.util.Arrays;

class ArrayDemo {
    public static void main(String args[]) {
        int[] marks = {85, 90, 78, 92};

        System.out.println("First element = " + marks[0]);
        System.out.println("Size of the array = " + marks.length);
        System.out.println(marks);
        System.out.println("Array content = " + Arrays.toString(marks));

        Arrays.sort(marks);

        System.out.print("All elements after sorting = ");
        for (int i = 0; i < marks.length; ++i) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();

        System.out.println("Binary search 90 = " + Arrays.binarySearch(marks, 90));
        System.out.println("Binary search 1 = " + Arrays.binarySearch(marks, 1));

    }
}

