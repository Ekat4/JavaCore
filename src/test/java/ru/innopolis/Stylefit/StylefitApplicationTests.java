
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import ru.innopolis.StyleFit.Application;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.repositories.ClientRepository;


import static org.assertj.core.api.Assertions.assertThat;
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
        // Создание и сохранение нового клиента
        Client client = new Client();
        client.setName("Иван Иванов");
        client = clientRepository.save(client);

        // Проверка, что клиент был сохранен
        assertThat(client.getId()).isNotNull();

        // Получение клиента по ID
        Client foundClient = clientRepository.findById(client.getId()).orElse(null);
        assertThat(foundClient).isNotNull();
        assertThat(foundClient.getName()).isEqualTo("Иван Иванов");

        // Удаление всех клиентов
        clientRepository.deleteAll();
        assertThat(clientRepository.findAll()).isEmpty();
    }
}