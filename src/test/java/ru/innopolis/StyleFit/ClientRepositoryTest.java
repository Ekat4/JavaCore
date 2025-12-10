package ru.innopolis.StyleFit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientRepository.deleteAll();
    }

    @Test
    void testSaveClient() {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setEmail("john@example.com");

        Client savedClient = clientRepository.save(client);

        assertThat(savedClient.getId()).isNotNull();
        assertThat(savedClient.getFirstName()).isEqualTo("John");
        assertThat(savedClient.getLastName()).isEqualTo("Doe");
        assertThat(savedClient.getFullName()).isEqualTo("John Doe");
    }

    @Test
    void testFindByEmail() {
        Client client = new Client();
        client.setFirstName("Jane");
        client.setLastName("Doe");
        client.setEmail("jane@example.com");
        clientRepository.save(client);

        Optional<Client> foundClient = clientRepository.findByEmail("jane@example.com");

        assertThat(foundClient).isPresent();
        assertThat(foundClient.get().getFirstName()).isEqualTo("Jane");
        assertThat(foundClient.get().getLastName()).isEqualTo("Doe");
    }

    @Test
    void testFindAllClients() {
        Client client1 = new Client();
        client1.setFirstName("Client");
        client1.setLastName("One");
        client1.setEmail("client1@example.com");

        Client client2 = new Client();
        client2.setFirstName("Client");
        client2.setLastName("Two");
        client2.setEmail("client2@example.com");

        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAll();

        assertThat(clients).hasSize(2);
    }

    @Test
    void testGetFullName() {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Smith");
        client.setEmail("john.smith@example.com");
        clientRepository.save(client);

        Optional<Client> foundClient = clientRepository.findByEmail("john.smith@example.com");

        assertThat(foundClient).isPresent();
        assertThat(foundClient.get().getFullName()).isEqualTo("John Smith");
    }
}
