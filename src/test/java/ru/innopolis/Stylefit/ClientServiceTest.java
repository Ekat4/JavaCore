package ru.innopolis.Stylefit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import ru.innopolis.StyleFit.Application;
import ru.innopolis.StyleFit.service.ClientService;

@SpringBootTest(classes = Application.class)
class ClientServiceTest {
    @Mock
    private ClientService clientService;
    @BeforeEach
  void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
   void testGetClientById() {
        // Your test logic here
    }

    @Test
   void testGetAllClients() {
        // Your test logic here
    }

    @Test
    void testDeleteClient() {
        // Your test logic here
    }
}