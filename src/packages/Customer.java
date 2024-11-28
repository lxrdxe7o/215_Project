package packages;

import java.util.Scanner;

import java.io.Serializable;

public 
class Customer implements Serializable {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String dob;
    private String id;

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
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email + "\nDOB: " + dob
                + "\nID: " + id;
    }

    public void updateCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        try {
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
}