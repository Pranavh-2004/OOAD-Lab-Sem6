public class PbyRef1
{
     
    // making a public member variable
    public int a;
     
    public PbyRef1() 
    {
        a = 10;
    }
     
    public static void main(String[] args) 
    {
 
        PbyRef1 eg = new PbyRef1();
         
        // Before calling the add() method
        System.out.println("Before calling method: " + eg.a);
         
        // calling method
        add(eg);
         
        // After calling the add() method
        System.out.println("after calling method: " + eg.a);
         
    }
     
    // add() method starts here that increments 'a' by 1
    public static void add (PbyRef1 obj) 
    {
        obj.a++;
    }
     
}