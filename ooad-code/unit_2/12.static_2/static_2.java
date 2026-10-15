class A {
    static void print() {
        System.out.println("This is class A");
    }
}

class B extends A {
    static void print() {
        System.out.println("This is class B");
    }
}

class Static2 {
    public static void main(String args[]) {
        B b = new B();
        A a = new B();

        a.print();
        b.print();

        A.print();
        B.print();
    }
}
