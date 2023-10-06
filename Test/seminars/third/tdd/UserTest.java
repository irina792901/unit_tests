import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;
    @BeforeEach
    void setUp() {
        user = new User("Alice", "password", false);
    }
    @Test
    public void testCreateUser() {
        Assertions.assertEquals("Alice", user.getName());
        Assertions.assertEquals("password", user.getPassword());
        assertFalse(user.isAdmin());
        assertTrue(user.isAuthenticate());
    }

    @Test
    public void testAuthenticate() {
        assertTrue(user.authenticate("Alice", "password"));
        assertFalse(user.authenticate("Alice", "wrongPassword"));
        assertFalse(user.authenticate("Bob", "password"));
    }

    @Test
    public void testSetName() {
        user.setName("Bob");
        Assertions.assertEquals("Bob", user.getName());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newPassword");
        Assertions.assertEquals("newPassword", user.getPassword());
    }

    @Test
    public void testIsAuthenticate() {
        assertTrue(user.authenticate("Alice", "password"));
        user.setAuthenticate(false);
        assertFalse(user.isAuthenticate());
    }
}