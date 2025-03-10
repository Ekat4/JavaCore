package homeworks.homework09;

public class App {
    public static void main(String[] args) {
        // Создаем автомобили
        PerformanceCar pCar1 = new PerformanceCar("Ferrari", "488", 2020, 600, 3, 15, 100);
        PerformanceCar pCar2 = new PerformanceCar("Lamborghini", "Huracan", 2021, 640, 3, 14, 90);
        ShowCar sCar = new ShowCar("McLaren", "720S", 2020, 710, 2, 12, 80);

        // Создаем гараж
        Garage garage = new Garage();

        // Паркуем автомобили в гараже
        garage.parkCar(pCar1);
        garage.parkCar(pCar2);
        garage.parkCar(sCar);

        // Выводим информацию о гараже
        System.out.println("Гараж:");
        System.out.println(garage);

        // Создаем гонку
        Race race = new Race("Monaco Grand Prix");

        // Добавляем участников в гонку
        race.addParticipant(pCar1);
        race.addParticipant(pCar2);
        race.addParticipant(sCar);

        // Выводим информацию о гонке
        System.out.println("\nИнформация о гонке:");
        System.out.println(race);
    }
}