import java.io.*; 
import java.util.*; 
    
public class MainPalRecursive 
{ 
    static int num_check;
    // check if num contains only one digit 
    public int oneDigit(int num) 
    { 
         if ((num >= 0) && (num < 10)) 
            return 1; 
        else
            return 0; 
    } 

    // The constructor 
    public MainPalRecursive (int num)
    {
        num_check = num;
    }

   //palindrome utility function
    public int isPalindrome_util (int num, int revNum) throws Exception 
    { 
        // base condition; return if num=0
        if (num == 0) 
        { 
            return revNum; 
        } 
	else 
        { 
            //call utility function recursively
            revNum = isPalindrome_util(num / 10, revNum); 
        } 
         // Check if first digit of num and revNum are equal 
        if (num % 10 == revNum % 10) 
        { 
            // if yes, revNum will move with num
            return revNum / 10; 
        }
        else 
        { 
            // exit 
            throw new Exception(); 
        } 
    } 
    //method to check if a given number is palindrome using palindrome utility function
    public int isPalindrome(int num) throws Exception 
    { 
        if (num < 0) 
            num = (-num); 
    
        int revNum = (num); 
        return this.isPalindrome_util(num, revNum); 
    } 
    
    public static void main(String args[]) 
    { 
        if (args.length > 0) // Command line argument is indeed passed
        {
            MainPalRecursive nPal = new MainPalRecursive (Integer.parseInt (args[0]));
            if (nPal.oneDigit (num_check) == 0)  // Number contains more than one digit
            {
                try 
                { 
                    nPal.isPalindrome(num_check); 
                    System.out.println("Yes, the given number " + num_check + " is a palindrome."); 
                } 
                catch (Exception e) 
                { 
                    System.out.println("No, the given number " + num_check + " is not a palindrome."); 
                }
            } 
            else
                System.out.println ("The number contains just one digit");
        }
        else
            System.out.println ("Usage: <java classname argument>");
    } 
}