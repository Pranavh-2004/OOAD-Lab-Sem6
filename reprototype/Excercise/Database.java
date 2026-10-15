//DATABASE (DIP)
interface Database {
    void saveOrder(Order order);
}

class MySQLDatabase implements Database {
    public void saveOrder(Order order) {
        System.out.println("Order saved in MySQL DB");
    }
}

class MongoDBDatabase implements Database {
    public void saveOrder(Order order) {
        System.out.println("Order saved in MongoDB");
    }
}
