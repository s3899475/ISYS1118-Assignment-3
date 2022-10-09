package Assignment3;

public class AuthorizedUser extends User {
    private String username;
    private String password;

    AuthorizedUser(String username, String password, EventStorage manager) {
        super(manager);
        
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
