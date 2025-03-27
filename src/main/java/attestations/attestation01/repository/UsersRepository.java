package attestations.attestation01.repository;

import attestations.attestation01.model.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository {
    boolean addUser(User user);

    Optional<User> getUser(String login);

    void create(User user);                          // Создание нового пользователя
    Optional<User> findById(String id);                        // Поиск пользователя по ID
    List<User> findAll();                            // Получение списка всех пользователей
    void update(User user);                          // Обновление данных пользователя
    void deleteById(String id);                      // Удаление пользователя по ID
    void deleteAll();                                // Удаление всех пользователей
}
