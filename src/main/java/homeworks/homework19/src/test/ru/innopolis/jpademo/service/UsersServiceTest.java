package ru.innopolis.jpademo.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.innopolis.jpademo.model.Users;
import ru.innopolis.jpademo.repository.UsersRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUsers() {
        Users user1 = new Users(1L, "Пользователь1");
        Users user2 = new Users(2L, "Пользователь2");
        when(usersRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<Users> users = usersService.getUsers();

        assertEquals(2, users.size());
        assertEquals("Пользователь1", users.get(0).getFio());
        assertEquals("Пользователь2", users.get(1).getFio());
    }

    @Test
    void testDeleteAllUsers() {
        usersService.deleteAllUsers();

        // Assert
        verify(usersRepository, times(1)).deleteAll();
    }

    @Test
    void testSaveUser () {
        // Arrange
        Users user = new Users(null, "Пользователь3");
        when(usersRepository.save(any(Users.class))).thenReturn(new Users(3L, "Пользователь3"));

        Users savedUser  = usersService.save(user);

        assertEquals("Пользователь3", savedUser .getFio());
        assertEquals(3L, savedUser .getId());
    }
@Test
    void  ById() {
        Users user = new Users(1L, "Пользователь1");
        when(usersRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<Users> foundUser  = usersService.getUser; ById(1L);


        assertEquals("Пользователь1", foundUser .get().getFio());
    }

    private void ById(long l) {
    }
}
