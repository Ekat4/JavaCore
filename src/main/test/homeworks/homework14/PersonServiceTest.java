package homeworks.homework14;

import homeworks.homework06.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private static PersonService personService;

    @BeforeAll
    static void init() {
        personService = new PersonService();
    }

    @Test
    void convertStringToPersonTest() {
        String line = "Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10";
        List<Person> result = personService.convertStringToPerson(line);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Павел Андреевич", result.get(0).getName());
        assertEquals(10000, result.get(0).getMoney());
        assertEquals("Анна Петровна", result.get(1).getName());
        assertEquals(2000, result.get(1).getMoney());
        assertEquals("Борис", result.get(2).getName());
        assertEquals(10, result.get(2).getMoney());
    }

    @Test
    void convertStringToPersonWithNull() {
        assertThrows(IllegalArgumentException.class, () -> personService.convertStringToPerson(null));
    }

    @Test
    void convertStringToPersonWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> personService.convertStringToPerson(""));
    }

    @Test
    void convertStringToPersonWithInvalidFormat() {
        String line = "Павел Андреевич 10000; Анна Петровна = 2000; Борис = 10"; // Пропущен знак "="
        assertThrows(IllegalArgumentException.class, () -> personService.convertStringToPerson(line));
    }

    @Test
    void convertStringToPersonWithExtraSpaces() {
        String line = "  Павел Андреевич  =  10000   ;   Анна Петровна  = 2000  ; Борис = 10 ";
        List<Person> result = personService.convertStringToPerson(line);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Павел Андреевич", result.get(0).getName());
        assertEquals(10000, result.get(0).getMoney());
        assertEquals("Анна Петровна", result.get(1).getName());
        assertEquals(2000, result.get(1).getMoney());
        assertEquals("Борис", result.get(2).getName());
        assertEquals(10, result.get(2).getMoney());
    }

    @Test
    void convertStringToPersonWithNegativeMoney() {
        String line = "Павел Андреевич = -10000; Анна Петровна = 2000";
        assertThrows(IllegalArgumentException.class, () -> personService.convertStringToPerson(line));
    }
}