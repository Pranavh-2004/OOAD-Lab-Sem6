class A {
    final String cinfo;

    A() {
        this.cinfo = "A";
    }

    final void print_cinfo() {
        System.out.println(this.cinfo);
    }
}

class B extends A {
    void print() {
        // this.cinfo = "B"; /// Error
        System.out.println(this.cinfo);
    }

    /// Error
    // @Override
    // void print_cinfo() {
    //     System.out.println(this.cinfo);
    // }
}

class Final {
    public static void main() {
        B b = new B();
        b.print();
        b.print_cinfo();
    }
}
