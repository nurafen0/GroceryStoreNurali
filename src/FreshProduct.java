public class FreshProduct extends Product {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String category, String expiryDate) {
        super(name, price, quantity, category); // super() must be first
        this.expiryDate = expiryDate;
    }

    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + ". Expiring: " + expiryDate);
    }

    // FIX: This is the method the error said was missing!
    public void checkQuality() {
        System.out.println(">>> Quality Control: " + name + " is fresh and ready for sale.");
    }
}