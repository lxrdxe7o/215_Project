package packages;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Motorcycle extends VehicleType implements Vehicle {

    public Motorcycle() {
    }

    public Motorcycle(String make, String model, String year, String color, double price, String vin, String type) {
        super(make, type);
    this.model = model;
    this.year = year;
    this.color = color;
    this.price = price;
    this.vin = vin;
}

public String getMake() {
    return make;
}

public String getModel() {
    return model;
}

public String getYear() {
    return year;
}

public String getColor() {
    return color;
}

public double getPrice() {
    return price;
}

public String getVin() {
    return vin;
}

public String getType() {
    return type;
}

public void setMake(String make) {
    this.make = make;
}

public void setModel(String model) {
    this.model = model;
}

public void setYear(String year) {
    this.year = year;
}

public void setColor(String color) {
    this.color = color;
}

public void setPrice(double price) {
    this.price = price;
}

public void setVin(String vin) {
    this.vin = vin;
}

public void setType(String type) {
    this.type = type;
}

public String toString() {
    return make + "," + model + "," + year + "," + color + "," + price + "," + vin + "," + type;
}

public static String toString(Motorcycle motorcycle) {
    return "Make : " + motorcycle.make + "\n" + "Model : " + motorcycle.model + "\n" + "Year : " + motorcycle.year + "\n" + "Color : " + motorcycle.color + "\n" + "Price : " + motorcycle.price + "\n" + "Vin no. : " + motorcycle.vin + "\n" + "Type : " + motorcycle.type;
}

@Override
public double discountedPrice(int discount) {
    return price - (price * discount / 100);
}

public double discountedPrice(double discount) {
    return price - (price * discount / 100);
}

public double discountedPrice(int discount, int additionalDiscount) {
    return price - (price * (discount + additionalDiscount) / 100);
}

@Override
public void updateVehicleInfo() {
    try (Scanner scanner = new Scanner(System.in)) {
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

        setMake(make);
        setModel(model);
        setYear(year);
        setColor(color);
        setPrice(Double.parseDouble(price));
        setVin(vin);
    } catch (Exception e) {
        System.out.println("An error occurred while updating vehicle information: " + e.getMessage());
    }
}

// overload the updateVehicleInfo method

public void updateVehicleInfo(String make, String model, String year, String color, double price, String vin) {
    setMake(make);
    setModel(model);
    setYear(year);
    setColor(color);
    setPrice(price);
    setVin(vin);
}

public static void saveMotorcycles(ArrayList<Motorcycle> motorcycles) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("motorcycles.dat"))) {
        for (Motorcycle motorcycle : motorcycles) {
            writer.write(motorcycle.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("An error occurred while saving motorcycles: " + e.getMessage());
    }
}

public static void loadMotorcycles(ArrayList<Motorcycle> motorcycles) {
    try (BufferedReader reader = new BufferedReader(new FileReader("motorcycles.dat"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 7) {
                motorcycles.add(new Motorcycle(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5], parts[6]));
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while loading motorcycles: " + e.getMessage());
    }
}

public static void searchMotorcycle(ArrayList<Motorcycle> motorcycles, String vin) throws MotorcycleNotFoundException {
    for (Motorcycle motorcycle : motorcycles) {
        if (motorcycle.getVin().equals(vin)) {
            System.out.println(motorcycle);
            return;
        }
    }
    throw new MotorcycleNotFoundException("Motorcycle with VIN " + vin + " not found.");
}

public static void updateMotorcycleInfo(ArrayList<Motorcycle> motorcycles, String vin) throws MotorcycleNotFoundException {
    for (Motorcycle motorcycle : motorcycles) {
        if (motorcycle.getVin().equals(vin)) {
            motorcycle.updateVehicleInfo();
            Motorcycle.saveMotorcycles(motorcycles);
            return;
        }
    }
    throw new MotorcycleNotFoundException("Motorcycle with VIN " + vin + " not found.");
}

static class MotorcycleNotFoundException extends Exception {
    public MotorcycleNotFoundException(String message) {
        super(message);
    }
}
}
