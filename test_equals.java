public class test_equals {
    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a == b);        // false (different objects!)
        System.out.println(a.equals(b));   // true (same content!)
    }    
}