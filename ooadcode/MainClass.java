// Create a Main class
public class MainClass 
{
  int x;  // Create a class attribute

  // Create a class constructor for MainClass
  public MainClass() 
  {
    x = 5;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) 
  {
    MainClass myObj = new MainClass(); // Create an object of class MainClass 
    // (This will call the constructor)
    System.out.println("x is " + myObj.x); // Print the value of x
    myObj = null;
    System.gc();
  }
  protected void finalize()
  {
    System.out.println("finalize method of MainClass");
  }
}







