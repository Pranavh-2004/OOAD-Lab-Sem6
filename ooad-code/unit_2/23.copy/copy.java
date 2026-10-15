class Demo {
    public int x;

    public Demo(int x) {
        this.x = x;
    }

    public Demo(Demo other) {
        this.x = other.x;
    }
}

class Copy {
    public static void main(String args[]) {
        Demo d = new Demo(10);
        Demo d_copy = d;
        Demo d_clone = new Demo(d);

        System.out.println("Before modification");
        System.out.println("d.x = " + d.x);
        System.out.println("d_copy.x = " + d_copy.x);
        System.out.println("d_clone.x = " + d_clone.x);
        System.out.println("========================");

        d.x++;

        System.out.println("After modification");
        System.out.println("d.x = " + d.x);
        System.out.println("d_copy.x = " + d_copy.x);
        System.out.println("d_clone.x = " + d_clone.x);
        System.out.println("========================");
    }
}
