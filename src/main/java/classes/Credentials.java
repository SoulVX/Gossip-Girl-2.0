package classes;

public class Credentials {
    private String username, password;

    public Credentials(final String username, final String password) {
        this.username = username; this.password = password;
    }

    public void changeUsername(final String username) {
        this.username = username;
    }

    public void changePassword(final String password) {
        this.password = password;
    }

    public String toString() {
        return "username: " + username + "\n" +
               "password: " + password;
    }
}
