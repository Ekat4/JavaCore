package ru.innopolis.jpademo;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.RequiredArgsConstructor;
import ru.innopolis.jpademo.model.Users;
import ru.innopolis.jpademo.service.UsersService;

import java.util.List;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor


public class Main {
    private final UsersService usersService;

    public static void main(String[] args) {
SpringApplication.run(Main.class, args);
    }
    @PostConstruct
    public void init() {
     List<Users> user = usersService.getUsers();
        log.info("Пользователь {}", user);

    }
}

