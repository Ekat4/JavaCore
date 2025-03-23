package homeworks.homework14;

import homeworks.homework06.Person;

import java.util.Arrays;
import java.util.List;

class PersonService {
    public List<Person> convertStringToPerson(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой!");
        }

        return Arrays.stream(line.split(";"))
                .map(e -> {
                    String[] elements = e.split("=");
                    if (elements.length != 2) {
                        throw new IllegalArgumentException("Некорректный формат данных для человека");
                    }
                    return new Person(elements[0].trim(), Double.parseDouble(elements[1].trim()));
                })
                .toList();
    }
}

