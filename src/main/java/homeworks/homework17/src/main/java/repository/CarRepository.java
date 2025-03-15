package homework09;

import homework09.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    void create(Car car);

    Optional<Car> findById(String id);

    List<Car> findAll();

    void update(Car car);

    void deleteById(String id);

    void deleteAll();

    void saveCar(Car car);
    List<Car> getAllCars();
    void loadCarsFromFile(String filePath);
}