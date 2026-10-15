class Math
{
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(int a, float b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}

class FunctionOverloading
{
    public static void main(String args[]) {
        System.out.println("1 + 2 = " + Math.add(1, 2));
        System.out.println("1 + 2.3 = " + Math.add(1, 2.3f));
        System.out.println("1 + 2 + 3 = " + Math.add(1, 2, 3));
    }
}
