public class Sale {
    // Category 1: Encapsulation - private fields
    private int saleId;
    private String productName;
    private double amount;
    private String status;

    // Constructor
    public Sale(int saleId, String productName, double amount) {
        this.saleId = saleId;
        this.productName = productName;
        // Using setter for validation during initialization
        setAmount(amount);
        this.status = "Ожидание";
    }

    // Default Constructor
    public Sale() {
        this.saleId = 0;
        this.productName = "Unknown";
        this.amount = 0;
        this.status = "Ожидание";
    }

    // Getters
    public int getSaleId() { return saleId; }
    public String getProductName() { return productName; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    // Setters with Validation (Defense Category 1)
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Error: Amount cannot be negative!");
            this.amount = 0;
        }
    }

    // Business Logic Methods
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            this.amount -= this.amount * (percent / 100);
            System.out.println(" Скидка " + percent + "% к чеку под номером " + saleId);
        }
    }

    public void completeSale() {
        this.status = "Оплачено";
    }

    @Override
    public String toString() {
        return " Чек номер- " + saleId + " товар " + productName + " Итого: " + amount + " Статус: " + status;
    }
}