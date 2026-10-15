// Hierarchical inheritance

class Bird {
  void fly() {
    System.out.println("I am a Bird");
  }
}
class Parrot extends Bird {
  void whatColourAmI() {
    System.out.println("I am green!");
  }
}
class Crow extends Bird {
  void whatColourAmI() {
    System.out.println("I am black!");
  }
}
class HierarchicalInheritance {
  public static void main(String args[]) {
    Parrot par = new Parrot();
    Crow cro = new Crow();
    //Call methods of Parrot Class
    par.whatColourAmI();
    par.fly();

    //Call methods of Crow Class
    cro.whatColourAmI();
    cro.fly();
  }
}
