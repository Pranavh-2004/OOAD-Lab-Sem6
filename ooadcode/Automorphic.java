// Program to check whether a given number (command line argument) is Automorphic
// Automorphic number:Is a number which is present in the last digit(s) of its square.
// Example: 5 x 5 = 25 (5 is present)
// 25 x 25 = 625 (25 is present)

import java.util.Scanner;
 
public class Automorphic 
{
     
    public static void main(String args[])
    {
        if (args.length > 0)
        {
            int num = Integer.parseInt (args[0]);
   
            int c=0, sqr = num*num;
            int temp = num;  
 
            //counting digits of num
            while(temp>0)
            {
                c++;
                temp=temp/10;
            }
 
            int lastSquareDigits = (int) (sqr%(Math.pow(10,c)));
 
            if(num == lastSquareDigits)
                System.out.println("Automorphic number");
            else
                System.out.println("Not an Automorphic number");
        }
        else
            System.out.println ("Usage: <java classname argument>");
    }
}