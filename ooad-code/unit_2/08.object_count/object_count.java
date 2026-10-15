class ObjectCount
{
    static int count;

    ObjectCount() {
        count += 1;
    }
}

class Main
{
    static void main(String args[]) {
        System.out.println(ObjectCount.count);
        ObjectCount c = new ObjectCount();
        System.out.println(ObjectCount.count);
    }
}
