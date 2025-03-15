package homework09;

import homework09.Car;
import homework09.CarRepository;
import org.junit.jupiter.api.Test;
import repository.Impl.CarRepositoryFileImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRepositoryTest {
    @Test
    public void testLoadCarsFromFile() throws IOException {
        // Создаем тестовый файл
        String testFilePath = "src/test/resources/test_cars.txt";
        try (FileWriter writer = new FileWriter(testFilePath)) {
            writer.write("Ferrari,488,2020,600,3,15,100\n");
            writer.write("Lamborghini,Huracan,2021,640,3,14,90\n");
            writer.write("McLaren,720S,2020,710,2,12,80\n");
        }

        CarRepository carRepository = new CarRepositoryFileImpl();
        carRepository.loadCarsFromFile(testFilePath);

        List<Car> cars = carRepository.getAllCars();
        assertEquals(3, cars.size()); // Предполагаем, что в файле 3 автомобиля

        // Удаляем тестовый файл после теста
        Files.deleteIfExists(Paths.get(testFilePath));
    }
}