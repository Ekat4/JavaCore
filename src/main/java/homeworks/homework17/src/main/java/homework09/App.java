package homework09;


import repository.Impl.CarRepositoryFileImpl;


import java.util.List;

public class App {
    public static void main(String[] args) {
        homework09.CarRepository carRepository = new CarRepositoryFileImpl();
        carRepository.loadCarsFromFile("src/main/resources/cars.txt"); // Путь к файлу с данными

        List<Car> cars = carRepository.getAllCars();
        Garage garage = new Garage();

        for (Car car : cars) {
            garage.parkCar(car);
        }

        // Выводим информацию о гараже
        System.out.println("Гараж:");
        System.out.println(garage);

        // Создаем гонку
        Race race = new Race("Monaco Grand Prix");

        // Добавляем участников в гонку
        for (Car car : cars) {
            race.addParticipant(car);
        }

        // Выводим информацию о гонке
        System.out.println("\nИнформация о гонке:");
        System.out.println(race);
    }
}
