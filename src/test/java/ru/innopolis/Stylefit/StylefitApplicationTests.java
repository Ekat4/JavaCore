
package ru.innopolis.StyleFit;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.innopolis.StyleFit.Application;
import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.models.Result;
import ru.innopolis.StyleFit.repositories.ClientRepository;
import ru.innopolis.StyleFit.repositories.ResultRepository;
import ru.innopolis.StyleFit.service.AuthService;
import ru.innopolis.StyleFit.service.ClientService;
import ru.innopolis.StyleFit.service.NotificationService;
import ru.innopolis.StyleFit.service.ResultAnalysisService;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = Application.class)
@SpringBootTest
class StylefitApplicationTests {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void contextLoads() {
        // Тест проверяет, что контекст приложения загружается успешно
        assertThat(clientRepository).isNotNull();
    }

    @Test
    void testClientRepository() {
        @SpringBootTest // Эта аннотация настраивает контекст приложения для тестирования
        class ClientRepositoryTest {

            @Autowired
            private ClientRepository clientRepository;

            @Test
            void testClientRepository() {
                // Создание и сохранение нового клиента
                Client client = new Client();
                client.setFirstName("Иван");
                client.setLastName("Иванов");
                client = clientRepository.save(client);

                // Проверка, что клиент был сохранен
                assertThat(client.getId()).isNotNull();

                // Получение клиента по ID
                Client foundClient = clientRepository.findById(client.getId()).orElse(null);
                assertThat(foundClient).isNotNull();
                assertThat(foundClient.getFullName()).isEqualTo("Иван Иванов"); // Изменено на getFullName()

                // Удаление клиента
                clientRepository.deleteById(client.getId());
                assertThat(clientRepository.findById(client.getId())).isEmpty();

                // Удаление всех клиентов
                clientRepository.deleteAll();
                assertThat(clientRepository.findAll()).isEmpty();
            }
        }
    }
}

@SpringBootTest(classes = Application.class)

class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void testAuthenticate_ValidUser () {
        boolean isAuthenticated = authService.authenticate("testUser ", "password123");
        assertThat(isAuthenticated).isTrue();
    }

    @Test
    void testAuthenticate_InvalidUser () {
        boolean isAuthenticated = authService.authenticate("testUser ", "wrongPassword");
        assertThat(isAuthenticated).isFalse();
    }

    @Test
    void testAuthenticate_NonExistingUser () {
        boolean isAuthenticated = authService.authenticate("nonExistingUser ", "password123");
        assertThat(isAuthenticated).isFalse();
    }
}


@SpringBootTest(classes = Application.class) // Use this if you need the Spring context
class ClientServiceTest {

    @MockBean // Use @MockBean to mock the ClientService if using Spring context
    private ClientService clientService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClientById() {
        // Your test logic here
    }

    @Test
    public void testGetAllClients() {
        // Your test logic here
    }

    @Test
    public void testDeleteClient() {
        // Your test logic here
    }
}

class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private Athlete athlete;

    @Mock
    private Result result;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendResultsUpdate_WithValidResult() {
        // Настройка
        when(athlete.getFirstName()).thenReturn("Иван");
        when(result.getTotalWorkouts()).thenReturn(5.0); // Возвращаем Double

        // Вызов метода
        notificationService.sendResultsUpdate(athlete, result);

        // Проверка
        // В данном случае можно использовать System.out или другой механизм для проверки вывода
    }


    @Test
    public void testSendResultsUpdate_WithNullResult() {
        // Настройка
        when(athlete.getFirstName()).thenReturn("Иван");

        // Вызов метода
        notificationService.sendResultsUpdate(athlete, null);

        // Проверка
        // Здесь также можно проверить вывод или поведение
    }

    // Здесь можно добавить дополнительные тесты для метода sendWorkoutReminder
}

@SpringBootTest(classes = Application.class) // Укажите ваш главный класс приложения
class ResultAnalysisServiceTest {

    @Autowired
    private ResultAnalysisService resultAnalysisService;

    @MockBean
    private ResultRepository resultRepository;
    @Test
    public void testCalculateAverageResults_WithResults() {
        // Настройка мока
        Long athleteId = 1L;
        Athlete athlete = new Athlete(); // Создайте объект Athlete, если нужно, или используйте мока
        athlete.setId(athleteId); // Убедитесь, что у спортсмена установлен идентификатор

        List<Result> results = Arrays.asList(
                new Result(1L, athlete, "Event1", 5.0, new Date()), // Убедитесь, что передаете правильные параметры
                new Result(2L, athlete, "Event2", 10.0, new Date()),
                new Result(3L, athlete, "Event3", 15.0, new Date())
        );

        // Настройка мока
        when(resultRepository.findByAthlete_Id(athleteId)).thenReturn(results);

        // Вызов метода
        double average = resultAnalysisService.calculateAverageResults(athleteId);

        // Отладочная информация
        System.out.println("Average calculated: " + average); // Отладочное сообщение

        // Проверка
        assertEquals(10.0, average, 0.01); // Проверяем, что среднее значение равно 10.0
    }



    @Test
    public void testCalculateAverageResults_WithoutResults() {
        // Настройка мока
        Long athleteId = 1L;
        when(resultRepository.findByAthlete_Id(athleteId)).thenReturn(Collections.emptyList());

        // Вызов метода
        double average = resultAnalysisService.calculateAverageResults(athleteId);

        // Проверка
        assertEquals(0.0, average, 0.01); // Проверяем, что среднее значение равно 0.0
    }
}

