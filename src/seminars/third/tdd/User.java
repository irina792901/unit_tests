package seminars.third.tdd;

public class User {
    private String name;
    private String password;
    private boolean isAdmin;
    private boolean isAuthenticate = true;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean authenticate(String inputName, String inputPassword) {
        if (inputName.equals(this.name) && inputPassword.equals(this.password)) {
            isAuthenticate = true;
        } else {
            isAuthenticate = false;
        }
        return isAuthenticate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        this.isAuthenticate = authenticate;
    }
}
