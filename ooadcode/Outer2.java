public class Outer2 
{
    private String message = "Hello from Outer!";

    // Inner class
    class Inner 
    {
        void showMessage() 
        {
            System.out.println(message);
        }
    }

    public static void main(String[] args) 
    {
        Outer2 outerObj = new Outer2();
        Outer2.Inner innerObj = outerObj.new Inner();
        innerObj.showMessage();
    }
}
