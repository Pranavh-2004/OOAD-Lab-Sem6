// Program to demonstrate the use of final methods
class Animal
{
    final void eat()
   {
        System.out.println("Animals are eating");
    }
}
public class DearA extends Animal
{
    void eat()
    {
        System.out.println("Dear is eating");
    }
    public static void main(String args[])
    {
        DearA dear = new DearA();
        dear.eat();
    }
}