public class FreshProduct extends Product {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String category, String expiryDate) {
        super(name, price, quantity, category);
        this.expiryDate = expiryDate;
    }

    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + ". Expiring: " + expiryDate);
    }

    @Override
    public String getCategory() {
        return "Fresh " + category;
    }

    public void checkQuality() {
        System.out.println(">>> Quality Control: " + name + " is fresh and ready for sale.");
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + " [Exp: " + expiryDate + "]";
    }
}