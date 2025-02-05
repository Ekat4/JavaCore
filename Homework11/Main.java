package Homeworks.Homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // Создаем несколько автомобилей
        cars.add(new Car("Red", "Toyota", 12345, 100000, 20000));
        cars.add(new Car("Blue", "Ford", 56789, 150000, 30000));
        cars.add(new Car("Black", "Honda", 98765, 200000, 40000));

        // Выводим все автомобили
        System.out.println("Все автомобили:");
        cars.forEach(System.out::println);

        // Удаляем автомобиль с номером 56789
        Optional<Car> removedCar = cars.stream()
                .filter(car -> car.getLicensePlate() == 56789)
                .findFirst();

        removedCar.ifPresent(cars::remove);

        // Выводим информацию о удаленном автомобиле
        System.out.println("\nАвтомобиль с номером 56789 удален:");
        System.out.println(removedCar.map(Car::toString).orElse("Автомобиль не найден"));

        // Выводим автомобили с цветом Black
        System.out.println("\nАвтомобили с цветом Black:");
        cars.stream()
                .filter(car -> "Black".equals(car.getColour()))
                .forEach(System.out::println);

        // Сортируем автомобили по стоимости
        cars.sort(Car::compareTo);
        System.out.println("\nАвтомобили отсортированные по стоимости:");
        cars.forEach(System.out::println);

        // Выводим среднюю стоимость автомобилей
        double averagePrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println("\nСредняя стоимость автомобилей: " + averagePrice + " рублей");
    }
}
