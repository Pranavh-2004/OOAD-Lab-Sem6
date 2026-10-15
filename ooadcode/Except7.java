public class Except7 {
    public static void main(String args[])
    {
        try 
        {      
            System.out.print("A");        
            throw new Exception(); 
        } 
        catch (Exception e) 
        {
            System.out.print("B");
        } 
        finally
        { 
            System.out.print("C");
            int num = 7/0; 
            System.out.print("D");
        }
        System.out.print("E");
    }
}