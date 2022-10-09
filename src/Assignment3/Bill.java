package Assignment3;

public class Bill {
    private int amount;
    private String description;

    Bill(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
