class TestParentClass {
  void test() {
    System.out.println("This is a Parent test Method");
  }
}
class TestChildClass extends TestParentClass {

  //The same method is present in the parent class.
  void test() {
    System.out.println("This is a Child test Method");
  }

  void display() {
    test(); //This calls the method of TestChildClass
    super.test(); //This calls the method of ParentChildClass
  }

}
class SuperMain2 {
  public static void main(String args[]) {
    TestChildClass tcc = new TestChildClass();
    tcc.display();
  }
}
