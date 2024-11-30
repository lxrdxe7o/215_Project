import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import packages.Car;
import packages.Motorcycle;
import packages.Customer;

<<<<<<< HEAD

public class App extends JFrame{
=======
public class App {
>>>>>>> origin/main
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
<<<<<<< HEAD
        // Create the main frame
        JFrame frame = new JFrame("Vehicle Inventory App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
=======
>>>>>>> origin/main

        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1));

        // Create buttons for each option
        JButton addVehicleButton = new JButton("Add a vehicle");
        JButton addCustomerButton = new JButton("Add a customer");
        JButton listVehiclesButton = new JButton("List all vehicles");
        JButton listCustomersButton = new JButton("List all customers");
        JButton searchVehicleButton = new JButton("Search and display a vehicle");
        JButton updateVehicleButton = new JButton("Search and update a vehicle");
        JButton searchCustomerButton = new JButton("Search and display a customer");
        JButton updateCustomerButton = new JButton("Search and update a customer");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        panel.add(addVehicleButton);
        panel.add(addCustomerButton);
        panel.add(listVehiclesButton);
        panel.add(listCustomersButton);
        panel.add(searchVehicleButton);
        panel.add(updateVehicleButton);
        panel.add(searchCustomerButton);
        panel.add(updateCustomerButton);
        panel.add(exitButton);

<<<<<<< HEAD
        // Add panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Add action listeners to buttons
        addVehicleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Add vehicle logic
            String vehicleType = JOptionPane.showInputDialog("Please enter the vehicle type (Car or Motorcycle):").trim().toLowerCase();
            if (!vehicleTypes.containsKey(vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1))) {
                JOptionPane.showMessageDialog(frame, "Invalid vehicle type.");
                return;
=======
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
>>>>>>> origin/main
            }
            vehicleType = vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1);

<<<<<<< HEAD
            String make = JOptionPane.showInputDialog("Please enter the make:");
            String model = JOptionPane.showInputDialog("Please enter the model:");
            String year = JOptionPane.showInputDialog("Please enter the year:");
            String color = JOptionPane.showInputDialog("Please enter the color:");
            String price = JOptionPane.showInputDialog("Please enter the price:");
            String vin = JOptionPane.showInputDialog("Please enter the VIN:");

            if (vehicleType.equals("Car")) {
                cars.add(new Car(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                Car.saveCars(cars);
            } else if (vehicleType.equals("Motorcycle")) {
                motorcycles.add(new Motorcycle(make, model, year, color, Double.parseDouble(price), vin, vehicleType));
                Motorcycle.saveMotorcycles(motorcycles);
            }
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Add customer logic
            String name = JOptionPane.showInputDialog("Please enter the customer name:");
            String address = JOptionPane.showInputDialog("Please enter the customer address:");
            String phone = JOptionPane.showInputDialog("Please enter the customer phone number:");
            String email = JOptionPane.showInputDialog("Please enter the customer email:");
            String dob = JOptionPane.showInputDialog("Please enter the customer date of birth:");
            String id = JOptionPane.showInputDialog("Please enter the customer ID:");

            customers.add(new Customer(name, address, phone, email, dob, id));
            Customer.saveCustomers(customers);
            }
        });

        listVehiclesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // List all vehicles logic
            StringBuilder vehiclesList = new StringBuilder("Cars:\n");
            for (Car car : cars) {
                vehiclesList.append(car.toString()).append("\n");
            }
            vehiclesList.append("Motorcycles:\n");
            for (Motorcycle motorcycle : motorcycles) {
                vehiclesList.append(motorcycle.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, vehiclesList.toString());
            }
        });

        listCustomersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // List all customers logic
            StringBuilder customersList = new StringBuilder();
            for (Customer customer : customers) {
                customersList.append(customer.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, customersList.toString());
            }
        });

        searchVehicleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Search and display a vehicle logic
            String vehicleType = JOptionPane.showInputDialog("Please enter the vehicle type (Car or Motorcycle):").trim().toLowerCase();
            String model = JOptionPane.showInputDialog("Please enter the model:");
            try {
                if (vehicleType.equals("car")) {
                Car.searchCar(cars, model);
                } else if (vehicleType.equals("motorcycle")) {
                Motorcycle.searchMotorcycle(motorcycles, model);
                } else {
                JOptionPane.showMessageDialog(frame, "Invalid vehicle type.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
            }
        });

        updateVehicleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Search and update a vehicle logic
            String vehicleType = JOptionPane.showInputDialog("Please enter the vehicle type (Car or Motorcycle):").trim().toLowerCase();
            String model = JOptionPane.showInputDialog("Please enter the model:");
            try {
                if (vehicleType.equals("car")) {
                Car.updateCarInfo(cars, model);
                } else if (vehicleType.equals("motorcycle")) {
                Motorcycle.updateMotorcycleInfo(motorcycles, model);
                } else {
                JOptionPane.showMessageDialog(frame, "Invalid vehicle type.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
            }
        });

        searchCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Search and display a customer logic
            String name = JOptionPane.showInputDialog("Please enter the customer name:");
            
            try {
                Customer.searchCustomer(customers, name);
            } catch (Customer.CustomerNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
            }
        });

        updateCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Search and update a customer logic
            String name = JOptionPane.showInputDialog("Please enter the customer ID:");
            try {
                for (Customer customer : customers) {
                Customer.searchCustomer(customers, name);
                customer.updateCustomerInfo();
                break;
                }
            } catch (Customer.CustomerNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Exit logic
            Car.saveCars(cars);
            Motorcycle.saveMotorcycles(motorcycles);
            Customer.saveCustomers(customers);
            JOptionPane.showMessageDialog(frame, "Exiting the Vehicle Inventory App.");
            System.exit(0);
            }
        });

        // Display the frame
        frame.setVisible(true);
            scanner.close();
        }
=======
        scanner.close();
    }
>>>>>>> origin/main
}

