public class FreshProduct extends Product {
    private String expiryDate; // Child-specific field

    public FreshProduct(String name, double price, int quantity, String category, String expiryDate) {
        super(name, price, quantity, category); // super() call as first line
        this.expiryDate = expiryDate;
    }

    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + ". Expiring: " + expiryDate);
    }

    public void checkQuality() {
        System.out.println("Quality check passed for " + name);
    }
}