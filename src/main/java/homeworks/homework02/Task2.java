package homeworks.homework02;

public class Task2 {

        public static void main(String[] args) {

            int firstNumber = 5;
            int secondNumber = 25;

            // Вычисляем
            int min = (firstNumber);
            int max = (secondNumber);
            int sum = firstNumber + secondNumber;
            int difference =  secondNumber- firstNumber;
            int product = firstNumber * secondNumber;
            double average = (firstNumber + secondNumber) / 2.0; // Используем 2.0 для получения дробного результата
            int distance = Math.abs(difference); // Расстояние - это абсолютное значение разницы


            // Выводим результаты
            System.out.printf("Сумма двух целых чисел: %d%n", sum);
            System.out.printf("Разница двух целых чисел: %d%n", difference);
            System.out.printf("Произведение двух целых чисел: %d%n", product);
            System.out.printf("Среднее из двух целых чисел: %.2f%n", average);
            System.out.printf("Расстояние двух целых чисел: %d%n", distance);
            System.out.printf("Максимальное целое число: %d%n", max);
            System.out.printf("Минимальное целое число: %d%n", min);

        }
    }

