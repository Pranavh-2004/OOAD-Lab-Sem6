class ABC
{
    private ABC()  {}
    void msg ()
    {
        System.out.println ("Welcome to the class");
    }
}

public class Sample
{
    public static void main (String args[])
    {
        ABC obj = new ABC();
        obj.msg();
    }
}
