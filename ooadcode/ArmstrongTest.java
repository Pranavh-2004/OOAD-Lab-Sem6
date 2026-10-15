import java.util.Scanner;

/**
 * Simple Java Program to check if a number is Armstrong number or not.
 * An Armstrong number of three digits is a number whose sum of cubes of its digits is equal 
 * to its number. For example 153 is an Armstrong number 
 * of 3 digit because 1^3+5^3+3^3 or   1+125+27=153
 * @author Javin
 */

// Modified to take the input as a command line argument
// Four Armstrong numbers between 1 and 500 are 153,370,371 and 407
public class ArmstrongTest{

    
    public static void main(String args[]) {
    
        if (args.length > 0)
        {
            int number = Integer.parseInt(args[0]); 
 
            //printing result
            if(isArmStrong(number))
            {
                System.out.println("Number : " + number 
                   + " is an Armstrong number");
            }
            else
            {
            System.out.println("Number : " + number
                      + " is not an Armstrong number");
            }
        }

    
    }

    /*
     * @return true if number is Armstrong number or return false
     */
    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while(number != 0){
            int remainder = number%10;
            result = result + remainder*remainder*remainder;
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
    } 
  
}
