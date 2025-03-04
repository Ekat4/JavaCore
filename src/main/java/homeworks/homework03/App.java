package homeworks.homework03;

import java.util.Random;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            //  объект Television с случайными параметрами
            Television tv = createTelevision(scanner, random);

            System.out.println("Созданный телевизор: " + tv);

            // Изменение параметров телевизора
            tv.setColor("Silver");
            tv.setMark("LG");
            tv.setVolt(110);

            System.out.println("Обновленный телевизор: " + tv);

            Television tv1 = createTelevision(scanner, random);
            Television tv2 = createTelevision(scanner, random);
            Television tv3 = createTelevision(scanner, random);

            System.out.println("Созданный телевизор 1: " + tv1);
            System.out.println("Созданный телевизор 2: " + tv2);
            System.out.println("Созданный телевизор 3: " + tv3);

        }

        public static Television createTelevision(Scanner scanner, Random random) {

            System.out.print("Введите цвет телевизора: ");
            String color = scanner.nextLine();

            System.out.print("Введите марку телевизора: ");
            String mark = scanner.nextLine();

            // Генерация случайного напряжения от 100 до 240
            Integer volt = random.nextInt(141) + 100;

            // экземпляр телевизора
            return new Television (color, mark, volt);
        }
    }
