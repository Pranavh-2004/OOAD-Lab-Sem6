// Program to check whether a number is a Harshad number or not
/* A Harshad number is a number that is divisible by the sum of its own digits. 
   1729 is a Harshad number because 1 + 7 + 2 + 9 = 19 and 1729 = 19 × 91. 
*/
import java.util.Scanner;

public class HarshadNumber  
{  
    public static void main(String[] args) 
    {  
        int num;  
        int rem = 0, sum = 0, n;  
        
        Scanner in_scan = new Scanner (System.in);
        System.out.print ("Key in the number:");
        num = in_scan.nextInt ();
        //Make a copy of num and store it in variable n  
        n = num;  
          
        //Calculate sum of digits  
        while(num > 0)
        {  
            rem = num%10;  
            sum = sum + rem;  
            num = num/10;  
        }  

        //Check whether number is divisible by sum of digits  
        if(n%sum == 0)  
            System.out.println(n + " is a harshad number");  
        else  
            System.out.println(n + " is not a harshad number");  
    }  
}  