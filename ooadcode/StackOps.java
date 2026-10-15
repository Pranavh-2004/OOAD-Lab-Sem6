// Program to demonstrate the use of the Stack class

import java.util.Stack;

class StackOps 
{
    public static void main(String[] args) 
    {
        Stack<String> animals= new Stack<>();

        // Add elements to Stack
        animals.push("Dog");
        animals.push("Horse");
        animals.push("Cat");

        System.out.println("Stack: " + animals);

        // Remove element stacks
        String element = animals.pop();
        System.out.println("Removed Element: " + element);

        // Access element from the top
        element = animals.peek();
        System.out.println("Element at top: " + element);
        // Search an element
        int position = animals.search("Horse");
        System.out.println("Position of Horse: " + position);
        // Check if stack is empty
        boolean result = animals.empty();
        System.out.println("Is the stack empty? " + result);

    }
}
