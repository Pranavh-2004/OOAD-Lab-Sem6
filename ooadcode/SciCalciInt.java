// Example using an interface

import java.lang.Math;

interface BasicCalci 
{
    int add ();

    int subtract();

    int multiply();
    
    int divide ();
    
    int modDiv();
}



public class SciCalciInt implements BasicCalci
{
    private double radians;
    private int res1, res2;

    public SciCalciInt (int var1, int var2, double degrees)
    {
        res1 = var1;
        res2 = var2;
        radians = Math.toRadians (degrees);
    }
    public int add ()
    {
	return (res1 + res2);
    }
    public int subtract ()
    {
	return (res1 - res2);
    }
    public int multiply ()
    {
	return (res1 * res2);
    }
    public int divide ()
    {
	return (res1 / res2);
    }
    public int modDiv ()
    {
	return (res1 % res2);
    }

    double calcSine ()
    {
        return (Math.sin (radians));
    }
    double calcCos ()
    {
        return (Math.cos (radians));
    }
    double calcTan ()
    {
        return (Math.tan (radians));
    }

    public static void main (String[] args)
    {
        int firstarg, secondarg;
        double angle;
        if (args.length > 2)
        {
            firstarg = Integer.parseInt (args[0]);
            secondarg = Integer.parseInt (args[1]);
            angle = Double.parseDouble (args[2]);
            
            SciCalciInt newCalci = new SciCalciInt (firstarg, secondarg, angle);
            // Trying to print the values of the private variables
            
            System.out.println ("Sum is: " + newCalci.add());
            System.out.println ("Quotient is: " + newCalci.divide());

            System.out.println ("Sine of the angle is: " + newCalci.calcSine());
            System.out.println ("Tan of the angle is: " + newCalci.calcTan());
        }
        else
            System.out.println ("Usage: java SciCalc <num1 num2 degree> ");

    }
}