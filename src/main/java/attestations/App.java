package attestations;

import attestations.attestation01.model.User;

import attestations.attestation01.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository() {
            @Override
            public boolean addUser(User user) {
                return false;
            }

            @Override
            public Optional<User> getUser(String login) {
                return Optional.empty();
            }

            @Override
            public void create(User user) {

            }

            @Override
            public Optional<User> findById(String id) {
                return Optional.empty();
            }

            @Override
            public List<User> findAll() {
                return List.of();
            }

            @Override
            public void update(User user) {

            }

            @Override
            public void deleteById(String id) {

            }

            @Override
            public void deleteAll() {

            }
        }; // Создаем экземпляр

        // Создание пользователей
        // Создание пользователей
        User  user1 = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2", "noisemc_99", "password_123", "password_123",
                "Крылов", "Виктор", "Павлович", 25, true);

        usersRepository.create(user1);
        System.out.println("Пользователь создан: " + user1.getLogin());

        // Поиск по ID
        Optional<User> foundUser  = usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        if (foundUser .isPresent()) {
            System.out.println("Найден пользователь: " + foundUser .get().getLogin());
        } else {
            System.out.println("Пользователь не найден.");
        }

        // Выгрузка всех пользователей
        List<User> allUsers = usersRepository.findAll();
        System.out.println("Все пользователи: ");
        for (User  user : allUsers) {
            System.out.println(user);
        }

        // Обновление пользователя
        user1.setAge(26); // Убедитесь, что метод setAge публичный
        usersRepository.update(user1);
        System.out.println("Обновленный пользователь: " + usersRepository.findById(user1.getId()).get().getAge());

        // Удаление пользователя
        usersRepository.deleteById(user1.getId());
        System.out.println("Пользователь удален.");

        // Проверка на наличие удаленного пользователя
        foundUser  = usersRepository.findById(user1.getId());
        if (foundUser .isPresent()) {
            System.out.println("Пользователь все еще существует.");
        } else {
            System.out.println("Пользователь не найден.");
        }

        // Удаление всех пользователей
        usersRepository.deleteAll();
        System.out.println("Все пользователи удалены. Текущий список: " + usersRepository.findAll());
    }
}