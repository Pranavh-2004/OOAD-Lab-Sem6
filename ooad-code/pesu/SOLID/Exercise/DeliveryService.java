interface DeliveryService {
    void deliverOrder(Order order);
}

class DeliveryPerson implements DeliveryService {
    public void deliverOrder(Order order) {
        System.out.println("Order assigned to delivery person.");
    }
}

class DroneDelivery implements DeliveryService {
    public void deliverOrder(Order order) {
        System.out.println("Order delivered via drone.");
    }
}