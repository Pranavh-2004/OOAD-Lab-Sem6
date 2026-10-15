class SuperClass {
  void methodSuper() {
    System.out.println("I am a super class method");
  }
}

// Inheriting SuperClass to SubClass
class SubClass extends SuperClass {
  void methodSubClass() {
    System.out.println("I am a sub class method");
  }
}
class IExample1 {
  public static void main(String args[]) 
  {
    SubClass obj = new SubClass();
    obj.methodSubClass();
    obj.methodSuper();
  }
}
