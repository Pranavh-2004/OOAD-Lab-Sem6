// Program to check whether a given number is a Neon number
/* Condition to be satisfied:
   The sum of digits of the square of the number is equal to the number itself
*/
import java.util.Scanner;

public class NeonNumber
{
    public static void main(String[] args)
    {
        int n, sqr = 1, sum = 0, r;
        
        for (int i = 0; i < 1000; i ++)
        {
            sqr = i * i;
            sum = 0;
            while (sqr > 0)
            {
                r = sqr % 10;
                sum = sum + r;
                sqr = sqr / 10;
            }
            if (i == sum)
            {
                System.out.println(i + "Neon Number");
            }
        }
    }
}