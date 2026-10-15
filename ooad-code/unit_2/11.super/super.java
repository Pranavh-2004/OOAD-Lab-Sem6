class A {
    int i;

    A() {
        i = 10;
    }

    void print() {
        System.out.println("[A] this.i = " + this.i);
    }
}

class B extends A {
    int i;

    B() {
        i = 20;
    }

    void print() {
        System.out.println("[B] this.i = " + this.i);
        System.out.println("[B] super.i = " + super.i);
        super.print();
    }
}

class Super {
    public static void main(String args[]) {
        B b = new B();
        b.print();

        System.out.println();

        A a = new B();
        System.out.println(a.i);
        a.print();
    }
}
