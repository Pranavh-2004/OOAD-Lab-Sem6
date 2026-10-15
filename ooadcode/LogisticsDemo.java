// Logistics Shipment Management System

// Interfaces and Abstractions

// SRP: Each interface has one responsibility
interface Vehicle {
    String getType();
    void deliver(String shipmentId);
}

interface Shipment {
    String getId();
    double getWeight();
}

// Concrete implementations

class Truck implements Vehicle {
    public String getType() { return "Truck"; }
    public void deliver(String shipmentId) {
        System.out.println("Truck delivering shipment " + shipmentId);
    }
}

class AirCargo implements Vehicle {
    public String getType() { return "Air Cargo"; }
    public void deliver(String shipmentId) {
        System.out.println("Air Cargo delivering shipment " + shipmentId);
    }
}

class StandardShipment implements Shipment {
    private String id;
    private double weight;

    public StandardShipment(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }
    public String getId() { return id; }
    public double getWeight() { return weight; }
}

// Factory pattern

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("aircargo")) {
            return new AirCargo();
        }
        throw new IllegalArgumentException("Unknown vehicle type");
    }
}

// Builder pattern

class ShipmentOrder {
    private Shipment shipment;
    private Vehicle vehicle;
    private String destination;

    public void setShipment(Shipment shipment) { this.shipment = shipment; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setDestination(String destination) { this.destination = destination; }

    @Override
    public String toString() {
        return "ShipmentOrder [shipment=" + shipment.getId() +
               ", vehicle=" + vehicle.getType() +
               ", destination=" + destination + "]";
    }
}

class ShipmentOrderBuilder {
    private ShipmentOrder order = new ShipmentOrder();

    public ShipmentOrderBuilder setShipment(Shipment shipment) {
        order.setShipment(shipment);
        return this;
    }

    public ShipmentOrderBuilder setVehicle(Vehicle vehicle) {
        order.setVehicle(vehicle);
        return this;
    }

    public ShipmentOrderBuilder setDestination(String destination) {
        order.setDestination(destination);
        return this;
    }

    public ShipmentOrder build() {
        return order;
    }
}

// Client code

public class LogisticsDemo {
    public static void main(String[] args) {
        // Factory usage
        Vehicle truck = VehicleFactory.createVehicle("truck");

        // Shipment creation
        Shipment shipment = new StandardShipment("SHP001", 1200.5);

        // Builder usage
        ShipmentOrder order = new ShipmentOrderBuilder()
                                .setShipment(shipment)
                                .setVehicle(truck)
                                .setDestination("Bengaluru Warehouse")
                                .build();

        System.out.println(order);
        truck.deliver(shipment.getId());
    }
}





/*
SOLID Principles in Action
- SRP → Vehicle, Shipment, VehicleFactory, ShipmentOrderBuilder each have one responsibility.
- OCP → Add new vehicle types (Ship, Drone) or shipment types (FragileShipment) without modifying existing code.
- LSP → Any Vehicle subtype can replace Vehicle seamlessly.
- ISP → Interfaces are small and focused (Vehicle, Shipment).
- DIP → Client depends on abstractions (Vehicle, Shipment), not concrete classes.
*/