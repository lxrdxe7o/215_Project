package packages;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String dob;
    private String id;

    public Customer() {
    }

    public Customer(String name, String address, String phone, String email, String dob, String id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return name + "," + address + "," + phone + "," + email + "," + dob + "," + id;
    }

    public static String toString(Customer customer) {
        return "Name : " + customer.name + "\n" + "Address : " + customer.address + "\n" + "Phone : " + customer.phone + "\n" + "Email : " + customer.email + "\n" + "DOB : " + customer.dob + "\n" + "ID : " + customer.id;
    }

    // make a similar search and exception method for the customer class

    public static void searchCustomer(ArrayList<Customer> customers, String name) throws CustomerNotFoundException {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                System.out.println(Customer.toString(customer));
                return;
            }
        }
        throw new CustomerNotFoundException("Customer with name " + name + " not found.");
    }

    // exception class method for the customer class

    public static class CustomerNotFoundException extends Exception {
        public CustomerNotFoundException(String message) {
            super(message);
        }
    }

    public void updateCustomerInfo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the name:");
            String name = scanner.nextLine();
            System.out.println("Please enter the address:");
            String address = scanner.nextLine();
            System.out.println("Please enter the phone:");
            String phone = scanner.nextLine();
            System.out.println("Please enter the email:");
            String email = scanner.nextLine();
            System.out.println("Please enter the DOB:");
            String dob = scanner.nextLine();
            System.out.println("Please enter the ID:");
            String id = scanner.nextLine();

            setName(name);
            setAddress(address);
            setPhone(phone);
            setEmail(email);
            setDob(dob);
            setId(id);
        } catch (Exception e) {
            System.out.println("An error occurred while updating customer information: " + e.getMessage());
        }
    }

    public void updateCustomerInfo(String name, String address, String phone, String email, String dob, String id) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setDob(dob);
        setId(id);
    }

    public static void saveCustomers(ArrayList<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.dat"))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving customers: " + e.getMessage());
        }
    }

    public static void loadCustomers(ArrayList<Customer> customers) {
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    customers.add(new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading customers: " + e.getMessage());
        }
    }
}