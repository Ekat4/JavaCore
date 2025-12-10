package ru.innopolis.StyleFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.StyleFit.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
    List<Client> findByFirstNameContaining(String firstName);
    List<Client> findByLastName(String lastName);
}
