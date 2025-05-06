
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
