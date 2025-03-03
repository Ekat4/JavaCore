package homeworks.homework09;
import java.util.Arrays;
import java.util.Objects;

public class Car {
    private String brand;         // Марка
    private String model;         // Модель
    private int year;            // Год выпуска
    private int horsepower;       // Мощность в лошадиных силах
    private int acceleration;      // Ускорение
    private int suspension;        // Подвеска
    private int durability;        // Долговечность

    public Car(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return String.format("Car [brand=%s, model=%s, year=%d, horsepower=%d, acceleration=%d, suspension=%d, durability=%d]",
                brand, model, year, horsepower, acceleration, suspension, durability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
                horsepower == car.horsepower &&
                acceleration == car.acceleration &&
                suspension == car.suspension &&
                durability == car.durability &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, horsepower, acceleration, suspension, durability);
    }
}

class PerformanceCar extends Car {
    private String[] addOns; // Дополнения

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower + 50, acceleration, (int)(suspension * 0.75), durability);
        this.addOns = new String[0]; // По умолчанию пустой массив
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "PerformanceCar " + super.toString() + ", addOns=" + Arrays.toString(addOns);
    }
}

class ShowCar extends Car {
    private int stars; // Оценка популярности

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = 0; // По умолчанию 0
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar " + super.toString() + ", stars=" + stars;
    }
}

