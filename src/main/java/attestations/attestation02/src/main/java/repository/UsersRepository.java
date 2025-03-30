package ru.innopolis.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.jpademo.model.Users;

import java.time.LocalDate;
import java.util.List;


public interface UsersRepository<users> extends JpaRepository<users, Long> {
    List<Users> findByCreationDate(LocalDate date);
}
