package homeworks.homework11;

public class Car {
    private String licensePlate; // Номер автомобиля
    private String model;        // Модель
    private String colour;       // Цвет
    private int mileage;         // Пробег
    private double price;        // Стоимость

    // Конструктор
    public Car(String licensePlate, String model, String colour, double price, int mileage) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.colour = colour;
        this.price = price;
        this.mileage = mileage;
    }

    // Геттеры и сеттеры
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return licensePlate + " " + model + " " + colour + " " + mileage + " " + price;
    }
}