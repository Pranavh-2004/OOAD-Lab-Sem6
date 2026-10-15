// Program to find whether a given number is a Peterson number or not
/* A number is said to be Peterson if the sum of factorials of each 
digit is equal to the number itself.
*/

import java.io.*;  
import java.util.*; 
 
public class PetersonNumber   
{  
     public static void main(String args[])  
    {  
        //constructor of the Scanner class  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter a number to check: ");  
        //reading a number from the user  
        int n=sc.nextInt();  
        //calling the user-defined function to check Peterson number  
        if (isPeterson(n))  
            System.out.println("The given number is a Peterson number.");  
        else  
            System.out.println("The given number is not a Peterson number.");  
    }  
    static int fact(int n)
    {
        if (n == 1)
        // base condition
            return 1;
        else   
            return n*fact(n-1);    
    }  
    //function to check whether the given number is Peterson or not  
    static boolean isPeterson(int n)  
    {  
        int num = n;  
        int sum = 0;  
        //loop executes until the condition becomes false  
        while (n > 0)   
        {  
            //determines the last digit of the given number      
            int digit = n % 10;  
            //determines the factorial of the digit and adds it to the variable sum  
            sum += fact (digit);  
            //removes the last digit of the given number  
            n = n / 10; 
        }  
        //compares sum with num, returns true or false 
        return (sum == num);  
    }  
}   