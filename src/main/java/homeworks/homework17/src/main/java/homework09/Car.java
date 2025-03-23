package homework09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String part, String part1, String part2, int i, String part3) {

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

    public String getId() {

        return null;
    }

    public CharSequence getColor() {

        return null;
    }
}

class PerformanceCar extends Car {
    private int topSpeed; // Максимальная скорость
    private int lapTime;  // Время круга

    public PerformanceCar(String part, String part1, int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof PerformanceCar)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return topSpeed == that.topSpeed && lapTime == that.lapTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topSpeed, lapTime);
    }
}

 class ShowCar extends Car {
    private String color; // Цвет автомобиля
    private String owner; // Владелец автомобиля

     public ShowCar(String part, String part1, String part2, String part3) {

     }

     @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof ShowCar)) return false;
        ShowCar that = (ShowCar) o;
        return Objects.equals(color, that.color) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, owner);
    }
}