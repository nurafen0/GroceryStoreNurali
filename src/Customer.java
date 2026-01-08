public class Customer {
    private String fullName;
    private double totalSpent;
    private int loyaltyPoints;
    private boolean isVip;

    public Customer(String fullName, double totalSpent, int loyaltyPoints) {
        this.fullName = fullName;
        this.totalSpent = totalSpent;
        this.loyaltyPoints = loyaltyPoints;
        this.isVip = totalSpent > 50000;
    }

    // Add your getters and setters here...

    public void addPoints(int points) {
        this.loyaltyPoints += points;
        System.out.println("Начислено " + points + " баллов клиенту " + fullName);
    }

    @Override
    public String toString() {
        return "Клиент: " + fullName + " баллы: " + loyaltyPoints + " ВИП: " + isVip;
    }
}