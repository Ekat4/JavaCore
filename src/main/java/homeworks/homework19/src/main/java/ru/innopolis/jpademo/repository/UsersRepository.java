package ru.innopolis.jpademo.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.jpademo.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
