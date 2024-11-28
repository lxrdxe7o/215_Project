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
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Map<String, String> vehicleTypes = new HashMap<>();
        vehicleTypes.put("Car", "Car");
        vehicleTypes.put("Motorcycle", "Motorcycle");

        // Load data from files
        loadVehicles(vehicles);
        loadCustomers(customers);

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
                String vehicleType = scanner.nextLine();
                if (!vehicleTypes.containsKey(vehicleType)) {
                    System.out.println("Invalid vehicle type.");
                    continue;
                }

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
                    vehicles.add(new Car(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                } else if (vehicleType.equals("Motorcycle")) {
                    vehicles.add(new Motorcycle(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                }

                // Save vehicles to file
                saveVehicles(vehicles);

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

                // Save customers to file
                saveCustomers(customers);

            } else if (option == 3) {
                for (Vehicle vehicle : vehicles) {
                    System.out.println(vehicle);
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

    private static void saveVehicles(ArrayList<Vehicle> vehicles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.dat"))) {
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving vehicles: " + e.getMessage());
        }
    }

    private static void loadVehicles(ArrayList<Vehicle> vehicles) {
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Deserialize the vehicle object from the line
                // This is a placeholder, you need to implement the deserialization logic

                // Example of deserialization logic
                // String[] parts = line.split(",");
                // vehicles.add(new Vehicle(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5], parts[6]));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading vehicles: " + e.getMessage());
        }
    }

    private static void saveCustomers(ArrayList<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.dat"))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving customers: " + e.getMessage());
        }
    }

    private static void loadCustomers(ArrayList<Customer> customers) {
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Deserialize the customer object from the line
                // This is a placeholder, you need to implement the deserialization logic
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading customers: " + e.getMessage());
        }
    }
}
