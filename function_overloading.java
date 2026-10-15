class FunctionOverloading {
    public static void main(String[] args) {
        Math m = new Math();
        System.out.println("1 + 2 = " + m.add(1,2));
        System.out.println("1 + 2.3 = " + m.add(1,2.3f));
    }
}

class Math {
    public int add(int a, int b) {
        return a + b;
    }
    public float add(float a, float b) {
        return a + b;
    }
}
    