package homeworks.homework10;

public class App {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Фильтрация по четности
        int[] evenNumbers = Sequence.filter(numbers, number -> number % 2 == 0);
        System.out.println("Четные числа: ");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Фильтрация по четности суммы цифр
        int[] evenSumDigits = Sequence.filter(numbers, number -> {
            int sum = 0;
            int temp = number; // Используем временную переменную, чтобы не изменять оригинальное число
            while (temp != 0) {
                sum += temp % 10; // Добавляем последнюю цифру к сумме
                temp /= 10; // Удаляем последнюю цифру
            }
            return sum % 2 == 0; } ); // Проверяем четность

        System.out.println("Числа с четной суммой цифр: ");
        for (int num : evenSumDigits) {
            System.out.print(num + " ");
        }
    }
}
