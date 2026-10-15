public class Except5 {
    public static void main(String args[]) 
    {
        try 
        {
            System.out.print("A");
            int num = 99/0;
            System.out.print("B");
        }
        catch(ArithmeticException ex) 
        {
            System.out.print("C");
            System.exit(0);
        }
        catch(Exception ex)
        {
            System.out.print("D");
        }
        finally
        {
            System.out.print("E");
        } 
        System.out.print("F");
}
}