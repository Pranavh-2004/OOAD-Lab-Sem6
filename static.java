class Test{
    //static varibale
    static int a = m1();
    static int b;
    int c;

    void m(){
        System.out.println("value of a : " + a);
    }

    //static block
    static{
        System.out.println("Inside static block");
    }

    //static method
    static int m1(){
        System.out.println("from m1");
        return 20;
    }

    //static method(main !!)
    public static void main(String[] args){
        System.out.println("value of a : " + a);
        System.out.println("from main");
        System.out.println("value of b : " + b);
        // System.out.println("value of c : " + c); // error: non-static variable c cannot be referenced from a static context

        (new Test()).m();
    }

  
}