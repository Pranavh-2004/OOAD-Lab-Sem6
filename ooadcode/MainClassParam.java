// Create a Main class
public class MainClassParam 
{
  int x;  // Create a class attribute

  // Create a class constructor for MainClass
  public MainClassParam(int val) 
  {
    x = val;  // Set the initial value for the class attribute x using the passed value
  }

  public static void main(String[] args) 
  {
    // Create an object of class MainClassParam
    MainClassParam myObj = new MainClassParam (10); 
    // (This will call the constructor)
    System.out.println("x is " + myObj.x); // Print the value of x
  }
}







