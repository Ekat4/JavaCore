package attestation01.repository.Impl;

import attestations.attestation01.model.User;
import attestation01.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.io.*;
import java.util.*;
import static java.nio.file.Files.lines;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.exceptions;




import java.util.ArrayList;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final List<User> USERS = new ArrayList<>();
    private static final String FILE_PATH = "users.txt"; // Укажите путь к файлу

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
        USERS.add(user);
        saveUsersToFile();
    }

    @Override
    public Optional<User> findById(String id) {
        if (USERS.isEmpty()) {
            findAll(); // Загружаем пользователей из файла, если список пуст
        }
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .or(() -> {
                    throw new NoSuchElementException("Пользователь не найден!");
                });
    }

    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                List<User> usersFromFile = br.lines()
                        .map(this::mapLineToUser )
                        .toList();

                USERS.addAll(usersFromFile);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
            }
        }
        return new ArrayList<>(USERS); // Возвращаем копию списка пользователей
    }

    private User mapLineToUser (String line) {
        String[] parts = line.split("\\|");
        return new User(
                parts[0],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7].isEmpty() ? null : parts[7],
                parts[8].isEmpty() ? null : Integer.parseInt(parts[8]),
                Boolean.parseBoolean(parts[9])
        );
    }

    @Override
    public void update(User user) {
        Optional<User> existingUser  = findById(user.getId());
        USERS.remove(existingUser .get());
        USERS.add(user);
        saveUsersToFile();
    }

    @Override
    public void deleteById(String id) {
        User userToDelete = findById(id)
                .orElseThrow(() -> new NoSuchElementException("Пользователь не найден!"));
        USERS.remove(userToDelete);
        saveUsersToFile();
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(""); // Очищаем файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User  user : USERS) {
                String userData = String.join("|",
                        user.getId(),
                        user.getDateAdded().toString(), // Предполагается, что у вас есть метод для получения даты
                        user.getLogin(),
                        user.getPassword(),
                        user.getPassword(), // confirmPassword
                        user.getLastName(),
                        user.getFirstName(),
                        user.getMiddleName() != null ? user.getMiddleName() : "",
                        user.getAge() != null ? user.getAge().toString() : "",
                        String.valueOf(user.isWorker())
                );
                writer.write(userData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
        }
    }
}