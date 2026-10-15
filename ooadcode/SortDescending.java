import java.util.Arrays;
import java.util.Collections;

public class SortDescending 
{
    public static void main(String[] args) 
    {
        Integer[] arr = { 5, 2, 8, 1, 9 };

        // Sort in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(Arrays.toString(arr)); // Output: [9, 8, 5, 2, 1]
    }
}
