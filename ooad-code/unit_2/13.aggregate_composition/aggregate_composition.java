//
// Aggregation
//

class Address {
    String state;
    String city;
    String street;

    Address(String state, String city, String street) {
        this.state = state;
        this.city = city;
        this.street = street;
    }

    void display() {
        System.out.println("state = " + this.state);
        System.out.println("city = " + this.city);
        System.out.println("street = " + this.street);
    }
}

class Student {
    String SRN;
    String name;
    Address address;

    Student(String SRN, String name, Address address) {
        this.SRN = SRN;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println("SRN = " + this.SRN);
        System.out.println("name = " + this.name);
        this.address.display();
    }
}

//
// Composition
//

class Engine {
    String name;

    Engine(String name) {
        this.name = name;
    }
}

class Car {
    String name;
    Engine engine;

    Car(String c_name, String e_name) {
        this.name = c_name;
        this.engine = new Engine(e_name);
    }

    void display() {
        System.out.println("car name = " + this.name);
        System.out.println("engine name = " + this.engine.name);
    }
}

//
// Main
//
class AggregationComposition {
    public static void main(String args[]) {
        /// Aggregation
        Address a = new Address("state_1", "city_1", "street_1");
        System.out.println(a);

        Student s1 = new Student("SRN_1", "name_1", a);
        Student s2 = new Student("SRN_2", "name_2", a);

        s1.display();
        System.out.println(s1.address);

        System.out.println();

        s2.display();
        System.out.println(s2.address);

        System.out.println();

        /// Composition
        Car c = new Car("car_1", "engine_1");
        c.display();

    }
}
