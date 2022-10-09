package Assignment3;

public class AuthorizedUser extends User {
    private String username;
    private String password;

    AuthorizedUser(String username, String password, Storage manager) {
        super(manager);
        
        this.username = username;
        this.password = password;
    }

    public void sendBill(int amount, String description) {
        storage.bills.add(new Bill(amount, description));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
