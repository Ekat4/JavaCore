package homeworks.homework13.utils;

import homeworks.homework13.exceptions.ParseCountException;

public class ParseUtils {

    // Метод для парсинга строки в Integer
    public static Integer parseCount(String stringInt) throws ParseCountException {
        try {
            return Integer.parseInt(stringInt);
        } catch (NumberFormatException e) {
            throw new ParseCountException("Невалидное значение");
        }
    }
}
