package Homeworks.Homework11;

public class Car implements Comparable<Car> {
    private String colour;
    private String model;
    private int licensePlate;
    private double price;
    private int mileage;

    public Car(String colour, String model, int licensePlate, double price, int mileage) {
        this.colour = colour;
        this.model = model;
        this.licensePlate = licensePlate;
        this.price = price;
        this.mileage = mileage;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return String.format("Car{colour='%s', model='%s', licensePlate=%d, price=%.2f, mileage=%d}",
                colour, model, licensePlate, price, mileage);
    }

    @Override
    public int compareTo(Car other) {
        return Double.compare(this.price, other.price); // Сравнение по цене
    }
}
