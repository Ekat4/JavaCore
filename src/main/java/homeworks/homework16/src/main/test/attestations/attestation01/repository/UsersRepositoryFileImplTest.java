package attestations.attestation01.repository; // Correct package declaration

import attestations.attestation01.model.User;
import attestations.attestation01.repository.Impl.UsersRepositoryFileImpl; // Ensure this import is correct
import attestations.attestation01.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Nested
public class UsersRepositoryFileImplTest {
    public static void main(String[] args) {}
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl(); // Assuming this is the correct implementation
        usersRepository.deleteAll(); // Ensuring a clean state before each test
    }

    @Test
    void testCreateUser () {
        User user = new User("1", LocalDateTime.now(), "user_1", "password1", "password1", "Иванов", "Иван", null, 30, false);
        usersRepository.create(user);

        Optional<User> foundUser  = usersRepository.findById("1");
        assertNotNull(foundUser );
        assertEquals("user_1", foundUser .get().getLogin());
    }

    @Test
    void testFindAllUsers() {
        User user1 = new User("1", LocalDateTime.now(), "user_1", "password1", "password1", "Иванов", "Иван", null, 30, false);
        User user2 = new User("2", LocalDateTime.now(), "user_2", "password2", "password2", "Петров", "Петр", null, 25, true);

        usersRepository.create(user1);
        usersRepository.create(user2);

        List<User> allUsers = usersRepository.findAll();
        assertEquals(2, allUsers.size());
    }

    @Test
    void testUpdateUser () {
        User user = new User("1", LocalDateTime.now(), "user_1", "password1", "password1", "Иванов", "Иван", null, 30, false);
        usersRepository.create(user);

        user.setAge(31);
        usersRepository.update(user);

        Optional<User> updatedUser  = usersRepository.findById("1");
        assertTrue(updatedUser .isPresent());
        assertEquals(31, updatedUser .get().getAge());
    }

    @Test
    void testDeleteUser () {
        User user = new User("1", LocalDateTime.now(), "user_1", "password1", "password1", "Иванов", "Иван", null, 30, false);
        usersRepository.create(user);

        usersRepository.deleteById("1");

        assertThrows(RuntimeException.class, () -> usersRepository.findById("1"));
    }

    @Test
    <NotFound>
    void testFindUser () {
        Optional<User> foundUser  = usersRepository.findById("999"); // Assuming "999" has not been created
        assertFalse(foundUser .isPresent(), "User  should not be found");
    }
}