public class PassByreference 
{
     
    /*
     *  The original value of 'a' will be changed as we are trying
     *  to pass the objects. Objects are passed by reference.
     */
     
    int a = 10;
    void call(PassByreference  eg) 
    {
        eg.a = eg.a+10;
    }
     
    public static void main(String[] args) 
    {
 
        PassByreference  eg = new PassByreference ();
        System.out.println("Before call-by-reference: " + eg.a);
         
        // passing the object as a value using pass-by-reference
        eg.call(eg);
        System.out.println("After call-by-reference: " + eg.a);
     }
}