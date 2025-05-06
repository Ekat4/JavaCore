package ru.innopolis.Stylefit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.StyleFit.Application;
import ru.innopolis.StyleFit.service.AuthService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)

class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void testAuthenticate_ValidUser () {
        boolean isAuthenticated = authService.authenticate("testUser ", "password123");
        assertThat(isAuthenticated).isTrue();
    }

    @Test
    void testAuthenticate_InvalidUser () {
        boolean isAuthenticated = authService.authenticate("testUser ", "wrongPassword");
        assertThat(isAuthenticated).isFalse();
    }

    @Test
    void testAuthenticate_NonExistingUser () {
        boolean isAuthenticated = authService.authenticate("nonExistingUser ", "password123");
        assertThat(isAuthenticated).isFalse();
    }
}
