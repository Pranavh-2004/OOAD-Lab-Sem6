public class Outer 
{
    static int outerValue = 10;

    // Static nested class
    static class Nested 
    {
        void display() 
        {
            System.out.println("Outer value: " + outerValue);
        }
    }

    public static void main (String[] args) 
    {
        Outer.Nested nestedObj = new Outer.Nested();
        nestedObj.display();
    }
}
