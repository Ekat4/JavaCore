package ru.innopolis.StyleFit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    // Конструктор для внедрения зависимости
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Получение всех клиентов
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Получение клиента по ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // Создание нового клиента
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Удаление клиента
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}