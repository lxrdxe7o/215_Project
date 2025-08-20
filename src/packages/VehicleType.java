package packages;

import java.io.Serializable;

public abstract class VehicleType implements Serializable {
    protected String make;
    protected String model;
    protected String year;
    protected String color;
    protected double price;
    protected String vin;
    protected String type;

    public VehicleType() {
    }

    public VehicleType(String make, String type) {
        this.make = make;
        this.type = type;
    }

    public abstract void updateVehicleInfo();

    public abstract double discountedPrice(int discount);
}
