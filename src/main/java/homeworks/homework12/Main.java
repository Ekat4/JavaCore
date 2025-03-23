package homeworks.homework12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fields = {"Фамилия", "Имя", "Отчество", "Дата рождения", "Номер телефона", "Пол", "Возраст"};
        String[] inputs = new String[fields.length];

        System.out.println("Введите данные (в произвольном порядке):");

        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i] + ": ");
            inputs[i] = scanner.nextLine();
        }

        // Проверка на количество полей
        if (inputs.length != fields.length) {
            throw new UnexpectedCountValueException("Количество введенных данных не совпадает с требуемым.");
        }
        try {
            Person person = new Person();
            person.setSurname(getFieldValue(inputs, "Фамилия"));
            person.setName(getFieldValue(inputs, "Имя"));
            person.setPatronymic(getFieldValue(inputs, "Отчество"));
            person.setBirthDate(getFieldValue(inputs, "Дата рождения"));
            person.setPhoneNumber(Long.parseLong(getFieldValue(inputs, "Номер телефона")));
            person.setGender(getFieldValue(inputs, "Пол").charAt(0));
            person.setAge(Integer.parseInt(getFieldValue(inputs, "Возраст")));

            String fileName = person.toString().split(" ")[0] + ".txt"; // Имя файла по фамилии
            writeToFile(fileName, person);
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static String getFieldValue(String[] inputs, String fieldName) {
        for (String input : inputs) {
            if (input.startsWith(fieldName)) {
                return input.split(":")[1].trim(); // Получаем значение после ":"
            }
        }
        return null; // Если поле не найдено
    }

    private static void writeToFile(String fileName, Person person) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}