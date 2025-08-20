package packages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Car extends VehicleType implements Vehicle {

  public Car() {
  }

  public Car(String make, String model, String year, String color, double price, String vin, String type) {
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

  public static String toString(Car car) {
    return "Make : " + car.make + "\n" + "Model : " + car.model + "\n" + "Year : " + car.year + "\n" + "Color : "
        + car.color + "\n" + "Price : " + car.price + "\n" + "Vin no. : " + car.vin + "\n" + "Type : " + car.type;
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

  public void updateVehicleInfo(String make, String model, String year, String color, double price, String vin) {
    setMake(make);
    setModel(model);
    setYear(year);
    setColor(color);
    setPrice(price);
    setVin(vin);
  }

  public static void saveCars(ArrayList<Car> cars) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars.dat"))) {
      for (Car car : cars) {
        writer.write(car.toString());
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("An error occurred while saving cars: " + e.getMessage());
    }
  }

  public static void loadCars(ArrayList<Car> cars) {
    try (BufferedReader reader = new BufferedReader(new FileReader("cars.dat"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
          cars.add(new Car(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5], parts[6]));
        }
      }
    } catch (IOException e) {
      System.out.println("An error occurred while loading cars: " + e.getMessage());
    }
  }

  public static void searchCar(ArrayList<Car> cars, String Model) throws CarNotFoundException {
    for (Car car : cars) {
      if (car.getModel().equals(Model)) {
        System.out.println(Car.toString(car));
        return;
      }
    }
    throw new CarNotFoundException("Car with model " + Model + " not found.");
  }

  public static void updateCarInfo(ArrayList<Car> cars, String model) throws CarNotFoundException {
    for (Car car : cars) {
      if (car.getModel().equals(model)) {
        car.updateVehicleInfo();
        Car.saveCars(cars);
        return;
      }
    }
    throw new CarNotFoundException("Car with VIN " + model + " not found.");
  }

  static class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
      super(message);
    }
  }
}
