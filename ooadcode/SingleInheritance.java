// Example of Single Inheritance

class Bird {
  void fly() {
    System.out.println("I am a Bird");
  }
}
// Inheriting SuperClass to SubClass
class Parrot extends Bird {
  void whatColourAmI() {
    System.out.println("I am green!");
  }
}
class SingleInheritance {
  public static void main(String args[]) {
    Parrot obj = new Parrot();
    obj.whatColourAmI();
    obj.fly();
  }
}
