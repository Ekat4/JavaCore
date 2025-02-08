package homeworks.homework11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    // Метод для сохранения данных в файл
    public static void saveCarsToFile(List<Car> cars, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                writer.write(car.getLicensePlate() + "|" + car.getModel() + "|" + car.getColour() + "|"
                        + car.getMileage() + "|" + car.getPrice());
                writer.newLine();
            }
            System.out.println("Данные успешно сохранены в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    // Метод для загрузки данных из файла
    public static List<Car> loadCarsFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String licensePlate = parts[0];
                    String model = parts[1];
                    String colour = parts[2];
                    int mileage = Integer.parseInt(parts[3]);
                    double price = Double.parseDouble(parts[4]);
                    cars.add(new Car(licensePlate, model, colour, price, mileage));
                }
            }
            System.out.println("Данные успешно загружены из файла " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных из файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата данных: " + e.getMessage());
        }
        return cars;
    }
}