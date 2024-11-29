import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import packages.Vehicle;
import packages.Car;
import packages.Motorcycle;
import packages.Customer;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Motorcycle> motorcycles = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Map<String, String> vehicleTypes = new HashMap<>();
        vehicleTypes.put("Car", "Car");
        vehicleTypes.put("Motorcycle", "Motorcycle");

        // Load data from files
        Car.loadCars(cars);
        Motorcycle.loadMotorcycles(motorcycles);
        Customer.loadCustomers(customers);

        System.out.println("Welcome to the Vehicle Inventory App!");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Add a customer");
            System.out.println("3. List all vehicles");
            System.out.println("4. List all customers");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Please enter the vehicle type (Car or Motorcycle):");
                String vehicleType = scanner.nextLine().trim().toLowerCase();
                if (!vehicleTypes.containsKey(vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1))) {
                    System.out.println("Invalid vehicle type.");
                    continue;
                }
                vehicleType = vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1);

                System.out.println("Please enter the make:");
                String make = scanner.nextLine();
                System.out.println("Please enter the model:");
                String model = scanner.nextLine();
                System.out.println("Please enter the year:");
                String year = scanner.nextLine();
                System.out.println("Please enter the color:");
                String color = scanner.nextLine();
                System.out.println("Please enter the price:");
                String price = scanner.nextLine();
                System.out.println("Please enter the VIN:");
                String vin = scanner.nextLine();

                if (vehicleType.equals("Car")) {
                    cars.add(new Car(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                    Car.saveCars(cars);
                } else if (vehicleType.equals("Motorcycle")) {
                    motorcycles.add(new Motorcycle(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                    Motorcycle.saveMotorcycles(motorcycles);
                }

            } else if (option == 2) {
                System.out.println("Please enter the customer name:");
                String name = scanner.nextLine();
                System.out.println("Please enter the customer address:");
                String address = scanner.nextLine();
                System.out.println("Please enter the customer phone number:");
                String phone = scanner.nextLine();
                System.out.println("Please enter the customer email:");
                String email = scanner.nextLine();
                System.out.println("Please enter the customer date of birth:");
                String dob = scanner.nextLine();
                System.out.println("Please enter the customer ID:");
                String id = scanner.nextLine();

                customers.add(new Customer(name, address, phone, email, dob, id));
                Customer.saveCustomers(customers);

            } else if (option == 3) {
                try {
                    System.out.println("Cars:");
                    for (Car car : cars) {
                        System.out.println(car.toString());
                    }
                    System.out.println("Motorcycles:");
                    for (Motorcycle motorcycle : motorcycles) {
                        System.out.println(motorcycle.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (option == 4) {
                for (Customer customer : customers) {
                    System.out.println(customer);
                }
            } else if (option == 5) {
                break;
            }
        }

        scanner.close();
    }
}
