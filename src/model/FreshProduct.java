package model;

public class FreshProduct extends Product implements Discountable {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String expiryDate) {
        super(name, price, quantity);
        setExpiryDate(expiryDate);
    }

    @Override
    public String getCategory() {
        return "Fresh Product";
    }

    @Override
    public void performAction() {

        System.out.println("Checking freshness for " + name + " (Exp: " + expiryDate + ")");
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }

        this.price -= this.price * (percentage / 100);
    }

    @Override
    public double getDiscountedPrice() {
        return this.price;
    }

    public void setExpiryDate(String expiryDate) {

        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry Date cannot be empty");
        }

        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
