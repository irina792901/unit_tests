import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private List<User> db;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        db = new ArrayList<>();
    }

    @Test
    public void testAddUser() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);
        boolean result = userRepository.findByName(user.getName());
        Assertions.assertTrue(result);
    }

    @Test
    public void testFindByNamePositive() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);
        boolean result = userRepository.findByName("username");
        Assertions.assertTrue(result);
    }

    @Test
    public void testFindByNameNegative() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);
        boolean result = userRepository.findByName("wrongUsername");
        Assertions.assertFalse(result);
    }

    @Test
    public void testLogoutAllUsers() {
        User adminUser = new User("Master", "password", true);
        User user1 = new User("Alice", "password", false);
        User user2 = new User("Bob", "password", false);

        // Add the users to the repository
        userRepository.addUser(adminUser);
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        // Вызов logoutAllUsers
        userRepository.logoutAll();

        // Check the authentication status of each user
        Assertions.assertTrue(adminUser.isAuthenticate());
        Assertions.assertFalse(user1.isAuthenticate());
        Assertions.assertFalse(user2.isAuthenticate());

        // Additional assertions
        Assertions.assertTrue(adminUser.isAdmin());
        Assertions.assertFalse(user1.isAdmin());
        Assertions.assertFalse(user2.isAdmin());
    }
}