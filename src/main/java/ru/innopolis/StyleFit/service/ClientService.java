package ru.innopolis.StyleFit.service;

import org.springframework.stereotype.Service;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.repositories.ClientRepository; // Ensure you import your repository

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    // Конструктор для внедрения зависимостей
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository; // Сохраняем репозиторий в поле
    }

    // Получение всех клиентов
    public List<Client> getAllClients() {
        return clientRepository.findAll(); // Используем метод репозитория для получения всех клиентов
    }

    // Получение клиента по ID
    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id); // Используем Optional для безопасного получения
        return client.orElse(null); // Возвращаем клиента или null, если не найден
    }

    // Создание нового клиента
    public Client createClient(Client client) {
        return clientRepository.save(client); // Сохраняем клиента через репозиторий
    }

    // Удаление клиента по ID
    public void deleteClient(Long id) {
        clientRepository.deleteById(id); // Удаляем клиента через репозиторий по ID
    }
}
