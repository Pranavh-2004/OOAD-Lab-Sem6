import java.util.ArrayList;

class ListDemo {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        System.out.println("Adding 10, 20 and 30 to list");
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Adding 1 at index 0");
        list.add(0, 1);

        System.out.println("List = " + list.toString() + "\n");

        System.out.println("Removing index 1");
        list.remove(1);

        System.out.println("List = " + list + "\n");

        System.out.println("List size = " + list.size() + "\n");
    }
}
