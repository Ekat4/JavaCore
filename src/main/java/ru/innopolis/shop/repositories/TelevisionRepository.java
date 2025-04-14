package ru.innopolis.shop.repositories;


import org.springframework.http.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.shop.entity.Television;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
