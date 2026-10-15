import java.util.Scanner;

public class ThrowThrowsExample 
{

    // The 'throws' keyword is used in the method signature to declare that 
    // the method might throw an ArithmeticException. This forces the calling 
    // method to handle it.
    public static void checkEligibility(int age) throws ArithmeticException  
    {
        if (age < 18) 
        {
            // The 'throw' keyword is used inside the method body to explicitly 
            // create and throw an exception instance when a specific condition 
            // is met.
/*
	    throw new Exception ("Generic exception");
*/
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");

/*
	    throw new ClassNotFoundException("Access denied - You must be at least 18 years old.");
*/
        } 
        else 
        {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args) 
    {
        Scanner myObj = new Scanner(System.in);  // Creating an object out of a class
        System.out.print("Enter a number:");
	int num = myObj.nextInt ();
        try 
        {
            // The method call is wrapped in a try-catch block to handle the 
            // potential exception declared by the 'throws' keyword.
            checkEligibility(num); 
        }
        catch (ArithmeticException e) 
        {
            // The catch block catches the exception and prints the error message.
            System.out.println("Exception caught: " + e.getMessage());
        }
 
	catch (Exception e) 
	{
    	    // This block catches any exception that is a subclass of Exception
            System.out.println("An exception occurred: " + e.getMessage());
            e.printStackTrace(); // It is good practice to log the stack trace
        }
	finally
	{
	    System.out.println ("finally block entered");
	}
        System.out.println("Program continues after exception handling.");
    }
}