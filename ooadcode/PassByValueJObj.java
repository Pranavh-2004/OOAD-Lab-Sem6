public class PassByValueJObj {

  public static void main(String[] args) {
    Integer a = new Integer(2);
    Integer b = new Integer(3);
    add(a, b);
    System.out.println("Result from main: " + (a + b));
  }

  private static void add(Integer a, Integer b) {
    // If a is simply assigned a reference to a new object
    // in heap memory, the original argument in main method
    // does not change
    a = new Integer(10);
    System.out.println("Result from method: " + (a + b));
  }
}
