package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> db = new ArrayList<>();

    public void addUser(User user) {
        if (user != null && !findByName(user.getName())) {
            db.add(user);
        }
    }

    public boolean findByName(String username) {
        if (username != null && !db.isEmpty()) {
            for (User user : db) {
                if (user.getName().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void logoutAll() {
        for (User user : db) {
            if (!user.isAdmin())
                user.setAuthenticate(false);
        }
    }
}