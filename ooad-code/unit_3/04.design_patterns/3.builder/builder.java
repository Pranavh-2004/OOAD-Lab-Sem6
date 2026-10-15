class Phone {
    String os;
    int ram;
    int storage;

    public Phone(String os, int ram, int storage) {
        this.os = os;
        this.ram = ram;
        this.storage = storage;
    }

    public void display() {
        System.out.println("os: " + os);
        System.out.println("ram: " + ram);
        System.out.println("storage: " + storage);
        System.out.println("");
    }
}

class PhoneBuilder {
    String os;
    int ram;
    int storage;

    public PhoneBuilder buildOS(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder buildRAM(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder buildStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public Phone build() {
        Phone p =  new Phone(os, ram, storage);
        reset();
        return p;
    }

    private void reset() {
        os = "";
        ram = 0;
        storage = 0;
    }
}

class PhoneDirector {
    private PhoneBuilder builder;

    public PhoneDirector(PhoneBuilder builder) {
        this.builder = builder;
    }

    public Phone buildAndroid() {
        return builder
                .buildOS("android")
                .buildRAM(8)
                .buildStorage(128)
                .build();
    }

    public Phone buildApple() {
        return builder
                .buildOS("apple")
                .buildRAM(8)
                .build();
    }
}

class Builder {
    public static void main(String args[]) {
        PhoneBuilder builder = new PhoneBuilder();
        PhoneDirector director = new PhoneDirector(builder);

        Phone phone1 = director.buildAndroid();
        phone1.display();

        Phone phone2 = director.buildApple();
        phone2.display();
    }
}
