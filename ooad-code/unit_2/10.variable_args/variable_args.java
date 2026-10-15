class Math {
    int add(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    String add(String... a) {
        String result = "";
        for (String i : a) {
            result += " " + i;
        }
        return result;
    }
}

class VariableArgs
{

    public static void main(String args[]) {
        Math m = new Math();
        System.out.println(m.add(10));
        System.out.println(m.add(10, 20));
        System.out.println(m.add(10, 20, 30));
        System.out.println(m.add("Hello", "World"));
    }
}
