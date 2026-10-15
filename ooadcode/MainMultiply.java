class Multiplier 
{
    static void Multiply(int a, int b)
    {
        System.out.println("Integer Multiplication, Result = "+ a*b);

    }
    // Method 2

    static void Multiply(double a, double b)
    {
        System.out.println("double Multiplication, Result = "+ a*b);
    }

    // Method 3

    static void Multiply(double a, double b, double c)
    {
        System.out.println("Three parameters, double Multiplication, Result = "+ a*b*c);
    }

}

public class MainMultiply 
{

    public static void main(String[] args) 
    {

        // using the first method

        Multiplier.Multiply(3,5);

        // using the second method

        Multiplier.Multiply(3.5,5.1);

        // using the third method

        Multiplier.Multiply(3.6,5.2, 6.3);
    }
}

