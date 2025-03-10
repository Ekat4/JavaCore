package homeworks.homework11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Создание списка автомобилей
        List<Car> cars = new ArrayList<>();

        // Заполнение списка автомобилей с использованием данных из задания
        cars.add(new Car("a123me", "Mercedes", "White", 8300000, 0));
        cars.add(new Car("b873of", "Volga", "Black", 673000, 0));
        cars.add(new Car("w487mn", "Lexus", "Grey", 900000, 76000));
        cars.add(new Car("p987hj", "Volga", "Red", 704340, 610));
        cars.add(new Car("c987ss", "Toyota", "White", 761000, 254000));
        cars.add(new Car("o983op", "Toyota", "Black", 740000, 698000));
        cars.add(new Car("p146op", "BMW", "White", 850000, 271000));
        cars.add(new Car("u893ii", "Toyota", "Purple", 440000, 210900));
        cars.add(new Car("l097df", "Toyota", "Black", 780000, 108000));
        cars.add(new Car("y876wd", "Toyota", "Black", 1000000, 160000));

        // Сохранение данных в файл
        String fileName = "car_collection.txt";
        CarRepository.saveCarsToFile(cars, fileName);

        // Загрузка данных из файла
        List<Car> loadedCars = CarRepository.loadCarsFromFile(fileName);

        // Вывод всех автомобилей
        System.out.println("Автомобили в базе:");
        System.out.println("Number Model Color Mileage Cost");
        loadedCars.forEach(System.out::println);

        // Заданные параметры
        String colorToFind = "Black"; // Цвет для поиска
        int mileageToFind = 0; // Пробег для поиска

        // Номера всех автомобилей, имеющих заданный цвет или нулевой пробег
        List<String> filteredCars = loadedCars.stream()
                .filter(car -> car.getColour().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getLicensePlate)
                .collect(Collectors.toList());

        System.out.println("Номера автомобилей по цвету или пробегу: " + String.join(" ", filteredCars));

        // Цвет автомобиля с минимальной стоимостью
        Optional<Car> cheapestCar = loadedCars.stream()
                .min(Comparator.comparingDouble(Car::getPrice));

        if (cheapestCar.isPresent()) {
            System.out.println("Цвет автомобиля с минимальной стоимостью: " + cheapestCar.get().getColour());
        } else {
            System.out.println("Нет автомобилей в базе.");
        }

        // Подсчет уникальных автомобилей
        long uniqueCarsCount = loadedCars.stream().distinct().count();
        System.out.println("Уникальные автомобили: " + uniqueCarsCount + " шт.");

        // Средняя стоимость модели Toyota
        double averagePriceToyota = loadedCars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase("Toyota"))
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);

        System.out.printf("Средняя стоимость модели Toyota: %.2f%n", averagePriceToyota);

        // Средняя стоимость модели Volvo
        double averagePriceVolvo = loadedCars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase("Volvo"))
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);

        System.out.printf("Средняя стоимость модели Volvo: %.2f%n", averagePriceVolvo);
    }
}