package packages;

import java.util.Scanner;

class Motorcycle extends VehicleType implements Vehicle {

    public Motorcycle(String make, String model, String year, String color, double price, String vin, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.vin = vin;
        this.type = type;
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

    public double discountentPrice(int discount) {
        return (price - (price * (discount / 100)));
    }

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
}

