package homeworks.homework13.exceptions;


// Исключение для обработки ошибок парсинга
public class ParseCountException extends Exception {
    public ParseCountException(String message) {
        super(message);
    }
}