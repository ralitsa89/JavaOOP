package P10ExercisePolymorphism.P02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        Vehicle car = getVehicle(tokens);

        tokens = scanner.nextLine().split(" ");
        Vehicle truck = getVehicle(tokens);

        tokens = scanner.nextLine().split(" ");
        Vehicle bus = getVehicle(tokens);


        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            Vehicle vehicle;
            try {

                switch (commandName) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        vehicle = vehicles.get(vehicleType);
                        if (vehicle instanceof Bus) {
                            bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                            System.out.println(bus.drive(distance));
                            bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                            continue;
                        }
                        String driveMessage = vehicle.drive(distance);
                        System.out.println(driveMessage);
                        break;
                    case "Refuel":
                        double fuelAmount = Double.parseDouble(tokens[2]);
                        vehicles.get(vehicleType).refuel(fuelAmount);
                        break;
                    case "DriveEmpty":
                        double driveEmptyDistance = Double.parseDouble(tokens[2]);
                        String driveEmptyMessage = bus.drive(driveEmptyDistance);

                        System.out.println(driveEmptyMessage);
                        break;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelAmount, consumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelAmount, consumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelAmount, consumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}

