package homework09;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Car> cars;

    public Garage() {
        cars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Garage:\n");
        for (Car car : cars) {
            result.append(car.toString()).append("\n");
        }
        return result.toString();
    }
}

