class A{
    int i = 10;
}

class B extends A { // child class
    int j = 20;
}

// class C extends A,B { // child class
//     int k = 30;
// }

class inheritanceDemo{
    public static void main(String[] args) {
        A aobj = new A();
        System.out.println(aobj.i);

        B bobj = new B();
        System.out.println(bobj.i);
        System.out.println(bobj.j);
    }
}
