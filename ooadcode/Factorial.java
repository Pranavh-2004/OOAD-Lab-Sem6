public class Factorial
{
    static int fact(int n)
    {
        if (n == 1)
        // base condition
            return 1;
        else   
            return n*fact(n-1);    
    }    
    public static void main(String[] args) 
    {
        int number = Integer.parseInt (args[0]);
        int result = fact(number);
     
         System.out.println("Result = " + result);
    }
}