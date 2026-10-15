class A{
    final String cinfo;
    
    A(){
        this.cinfo = "A";
    }

    final void printInfo(){
        System.out.println("This is class A with info: " + cinfo);
    }   
}

class B extends A{
    void print(){
        // error: cannot assign a value to final variable cinfo
        // this.cinfo = "B"; // This line will cause a compilation error
        System.out.println(this.cinfo);
    }
}

class Final {
    public static void main(String[] args) {
        B b = new B();
        b.print();
        b.printInfo();
    }
}
