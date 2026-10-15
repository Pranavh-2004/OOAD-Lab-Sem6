class TestParentClass {
  TestParentClass(int num) {
    System.out.println("This is the Parent class constructor " + num);
  }
}
class TestChildClass extends TestParentClass {
  TestChildClass(int a, int b) {
    super(b);
    System.out.println("This is the Child class constructor " + a);
  }
}
class SuperMain4 {
  public static void main(String args[]) {
    TestChildClass tcc = new TestChildClass(10, 20);
  }
}
