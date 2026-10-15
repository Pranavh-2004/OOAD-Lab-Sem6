// Program to show the use of "super" keyword 

class TestParentClass {
  int var = 100;
}
class TestChildClass extends TestParentClass {
  int var = 50; //Same variable is present in both parent and child

  void display() {
    System.out.println("The var value of child: " +
      var);
    System.out.println("The var value of parent: " + super.var);
    //using the super keyword will refer to parent class variables
  }

}
class SuperMain1 {
  public static void main(String args[]) {
    TestChildClass tcc = new TestChildClass();
    tcc.display();
  }
}
