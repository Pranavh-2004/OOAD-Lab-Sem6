import java.io.*;
import java.util.*;

abstract class SmartDevice {
    int deviceId;
    String deviceName;
    boolean powerStatus;

    SmartDevice(int deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.powerStatus = false;
    }

    void turnOn() {
        powerStatus = true;
    }

    void turnOff() {
        powerStatus = false;
    }

    abstract double calculatePowerConsumption();

    void displayDeviceDetails() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Power Status: " + (powerStatus ? "ON" : "OFF"));
        System.out.printf("Power Consumption: %.2f", calculatePowerConsumption());
    }
}

class SmartLight extends SmartDevice {
    double wattage;

    SmartLight(int id, String name, double wattage) {
        super(id, name);
        this.wattage = wattage;
    }

    double calculatePowerConsumption() {
        return wattage * 5;
    }
}

class SmartFan extends SmartDevice {
    int speedLevel;
    double baseWattage;

    SmartFan(int id, String name, int speedLevel, double baseWattage) {
        super(id, name);
        this.speedLevel = speedLevel;
        this.baseWattage = baseWattage;
    }

    double calculatePowerConsumption() {
        return baseWattage * speedLevel * 3;
    }
}

class SmartAC extends SmartDevice {
    int temperatureSetting;
    double powerRating;

    SmartAC(int id, String name, int temperatureSetting, double powerRating) {
        super(id, name);
        this.temperatureSetting = temperatureSetting;
        this.powerRating = powerRating;
    }

    double calculatePowerConsumption() {
        return powerRating * 8;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            if (!sc.hasNextInt()) return;
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > 3) return;

            if (!sc.hasNextInt()) return;
            int deviceId = sc.nextInt();
            sc.nextLine();

            if (deviceId < 1 || deviceId > 1_000_000) return;

            if (!sc.hasNextLine()) return;
            String deviceName = sc.nextLine();

            SmartDevice device = null;

            if (choice == 1) {
                if (!sc.hasNextDouble()) return;
                double wattage = sc.nextDouble();
                if (wattage < 0 || wattage > 5000) return;
                device = new SmartLight(deviceId, deviceName, wattage);

            } else if (choice == 2) {
                if (!sc.hasNextInt()) return;
                int speed = sc.nextInt();
                if (speed < 1 || speed > 5) return;

                if (!sc.hasNextDouble()) return;
                double base = sc.nextDouble();
                if (base < 0 || base > 5000) return;

                device = new SmartFan(deviceId, deviceName, speed, base);

            } else if (choice == 3) {
                if (!sc.hasNextInt()) return;
                int temp = sc.nextInt();
                if (temp < 16 || temp > 30) return;

                if (!sc.hasNextDouble()) return;
                double rating = sc.nextDouble();
                if (rating < 0 || rating > 5000) return;

                device = new SmartAC(deviceId, deviceName, temp, rating);
            }

            if (device != null) {
                device.turnOn();  
                device.displayDeviceDetails();
            }

        } catch (Exception e) {
        }
    }
}