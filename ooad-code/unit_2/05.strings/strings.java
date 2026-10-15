class Strings
{
    public static void main(String args[]) {
        /// Strings are immutable
        String s1 = new String("java");
        s1 = s1.concat(" language");
        System.out.println(s1);
    }
}
