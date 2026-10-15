class TestParentClass {
  TestParentClass() {
    System.out.println("This is the Parent class constructor");
  }
}
class TestChildClass extends TestParentClass {
  TestChildClass() {
    super();
    System.out.println("This is the Child class constructor");
  }
}
class SuperMain3 {
  public static void main(String args[]) {
    TestChildClass tcc = new TestChildClass();
  }
}
