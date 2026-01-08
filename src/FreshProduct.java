public class FreshProduct extends Product {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String category, String expiryDate) {
        super(name, price, quantity, category); // super() must be the first line [cite: 122]
        this.expiryDate = expiryDate;
    }

    @Override
    public void performAction() { // Override 1 [cite: 125]
        System.out.println("Checking freshness for " + name + ". Expiring: " + expiryDate);
    }

    @Override
    public String toString() { // Override 2 [cite: 125]
        return super.toString() + " | Expiry: " + expiryDate;
    }

    // Unique Method 1 [cite: 128]
    public void checkQuality() {
        System.out.println("Quality check passed for " + name);
    }

    // Unique Method 2 [cite: 128]
    public boolean isExpired() {
        return false; // Placeholder logic
    }
}