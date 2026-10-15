import java.util.ArrayList;

public class UseObject 
{
  public static void main(String[] args) 
  {

    // getClass() with Object
    Object obj1 = new Object();
    System.out.println("Class of obj1: " + obj1.getClass());

    // getClass() with String
    String obj2 = new String();
    System.out.println("Class of obj2: " + obj2.getClass());

    // getClass() with ArrayList
    ArrayList<Integer> obj3 = new ArrayList<>();
    System.out.println("Class of obj3: " + obj3.getClass());
  }
}