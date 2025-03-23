package homework09;

import homework09.Car;
import homework09.PerformanceCar;
import homework09.ShowCar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
class CarRepositoryFileImpl implements homework09.CarRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void create(Car car) {

    }

    @Override
    public Optional<Car> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Car> findAll() {
        return List.of();
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void saveCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars); // Возвращаем копию списка для предотвращения изменений извне
    }

    @Override
    public void loadCarsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Car car = createCarFromParts(parts);
                if (car != null) {
                    saveCar(car);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке автомобилей из файла: " + e.getMessage());
        }
    }

    private Car createCarFromParts(String[] parts) {
        // Предполагаем, что первый элемент - это тип автомобиля
        String type = parts[0].trim();
        switch (type) {
            case "PerformanceCar":
                return new PerformanceCar(parts[1], parts[2], Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                        Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
            case "ShowCar":
                return new ShowCar(parts[1], parts[2], parts[3], parts[4]);
            default:
                System.err.println("Неизвестный тип автомобиля: " + type);
                return null;
        }
    }
}