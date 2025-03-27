package ru.innopolis.jpademo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import ru.innopolis.jpademo.model.Users;
import ru.innopolis.jpademo.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {


    private final UsersRepository usersRepository;
    public Optional<Users> getUser;

    public Users getUser(Long id) {
        return usersRepository.findById(id)
                .orElseThrow();
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();

    }

    public Users save(Users user) {
        return user;
    }

    public void deleteAllUsers() {
    }
}
