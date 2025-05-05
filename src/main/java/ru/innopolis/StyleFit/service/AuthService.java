package ru.innopolis.StyleFit.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // Пример хранилища пользователей (в реальном приложении используйте базу данных)
    private static final Map<String, String> users = new HashMap<>();

    static {
        // Добавляем тестового пользователя (в реальном приложении используйте хеширование паролей)
        users.put("testUser ", "password123"); // username: testUser, password: password123
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}



