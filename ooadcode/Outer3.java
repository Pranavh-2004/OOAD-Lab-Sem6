class Outer3 
{
    void display() 
    {
        // Inner class defined inside a method
        class LocalInner 
        {
            void print() 
            {
                System.out.println("Inside method-local inner class");
            }
        }

        LocalInner local = new LocalInner();
        local.print();
    }

    public static void main(String[] args) 
    {
        Outer3 obj = new Outer3();
        obj.display();
    }
}

