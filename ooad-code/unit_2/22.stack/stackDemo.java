import java.util.Stack;

class StackDemo {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack = " + stack);
        System.out.println("Stack top = " + stack.peek());

        stack.pop();

        System.out.println("Stack = " + stack);
        System.out.println("Stack top = " + stack.peek());
    }
}
