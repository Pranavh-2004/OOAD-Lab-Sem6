interface MotorVehicle {
    void build();
}

class Motorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}

class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}

class VehicleFactory {
    public MotorVehicle build(String type) {
        if (type.equals("motorcycle")) {
            System.out.println("Building motorcycle");
            return new Motorcycle();
        }
        else if (type.equals("car")) {
            System.out.println("Building the car")
            return new Car();
        }
        throw new IllegalArgumentException("");
    }
}

class Factory {
    public static void main(String args[]) {
        VehicleFactory factory = new VehicleFactory();

        MotorVehicle motorcycle = factory.build("motorcycle");
        MotorVehicle car = factory.build("car");
    }
}
