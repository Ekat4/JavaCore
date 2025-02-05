package Homeworks.Homework11;

import java.util.Comparator;

public interface CarCollection extends Iterable<Car> {
    void add(Car car);
    void remove(Car car);
    Car get(int index);
    int size();
    void clear();
    boolean contains(Car car);
    boolean isEmpty();
    void sort(Comparator<Car> comparator);
    void reverse();


    default void print() {
        for (Car car : this) {
            System.out.println(car);
        }
    }
    // Вычисление средней цены автомобилей в коллекции
    default double calculateAveragePrice() {
        if (isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Car car : this) {
            sum += car.getPrice();
        }
        return sum / size();
    }
}