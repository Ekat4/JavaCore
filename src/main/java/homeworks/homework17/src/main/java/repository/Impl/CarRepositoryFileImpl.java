

package repository.Impl;


import homework09.Car;
import homework09.CarRepository;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
public class CarRepositoryFileImpl implements CarRepository {
    private static final List<Car> CARS = new ArrayList<>();
    private static final String FILE_PATH = "cars.txt"; // Specify the path to the file

    @Override
    public void create(Car car) {
        CARS.add(car);
        saveCarsToFile();
    }

    @Override
    public Optional<Car> findById(String id) {
        if (CARS.isEmpty()) {
            findAll(); // Load cars from file if the list is empty
        }
        return CARS.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .or(() -> {
                    throw new NoSuchElementException("Car not found!");
                });
    }

    @Override
    public List<Car> findAll() {
        if (CARS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                List<Car> carsFromFile = br.lines()
                        .map(this::mapLineToCar)
                        .toList();
                CARS.addAll(carsFromFile);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        return new ArrayList<>(CARS); // Return a copy of the car list
    }

    private Car mapLineToCar(String line) {
        String[] parts = line.split("\\|");
        return new Car(
                parts[0],
                parts[1],
                parts[2],
                Integer.parseInt(parts[3]),
                parts[4]
        );
    }

    @Override
    public void update(Car car) {
        Optional<Car> existingCar = findById(car.getId());
        CARS.remove(existingCar.get());
        CARS.add(car);
        saveCarsToFile();
    }

    @Override
    public void deleteById(String id) {
        Car carToDelete = findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car not found!"));
        CARS.remove(carToDelete);
        saveCarsToFile();
    }

    @Override
    public void deleteAll() {
        CARS.clear();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(""); // Clear the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveCarsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Car car : CARS) {
                String carData = String.join("|",
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        String.valueOf(car.getYear()),
                        car.getColor()
                );
                writer.write(carData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    @Override
    public void saveCar(Car car) {

    }

    @Override
    public List<Car> getAllCars() {
        return List.of();
    }

    @Override
    public void loadCarsFromFile(String filePath) {

    }
}
