// Program to check whether a given number is a magic number
/* If the sum of its digits is calculated till a single digit is obtained by recursively 
   adding the sum of its digits; if the single digit turns out to be 1, then the number 
   is a magic number
*/

import java.util.Scanner;

public class MagicNumber
{
    public static void main(String[] args)
    {
        int num, r = 1, sum = 0;
        // For numbers with >= 2 digits
        // Let us do it for all numbers between 1 and 1000
        for (int i = 1; i <= 1000; i ++)
        {
            num = i;
            r = 1;
            sum = 0;
            while (num > 9)
            {
                while (num > 0)
                {
                    r = num % 10;
                    sum = sum + r;
                    num = num / 10;
                }
                num = sum;
                sum = 0;
            }
            if (num == 1)
            {
                System.out.println(i + " is a Magic Number");
            }
          }
    }
}
