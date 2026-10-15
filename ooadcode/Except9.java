public class Except9{
    public static void main(String args[])
    {
        try 
        {   
            System.out.print("A");
            throw 99; 
        } 
        catch (int ex) 
        {
            System.out.print("B");
        } 
    }
}