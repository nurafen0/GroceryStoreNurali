package model;

public class FreshProduct extends Product implements Discountable {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String expiryDate) {
        super(name, price, quantity);
        setExpiryDate(expiryDate);
    }

    // 1. Реализация метода из абстрактного класса Product
    @Override
    public String getCategory() {
        return "Fresh Product";
    }

    // 2. Реализация метода из абстрактного класса Product
    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + " (Exp: " + expiryDate + ")");
    }

    // 3. Реализация первого метода
    @Override
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        this.price -= this.price * (percentage / 100);
    }

    // 4. Реализация второго метода
    @Override
    public double getDiscountedPrice() {
        return this.price;
    }

    // Сеттер с валидацией
    public void setExpiryDate(String expiryDate) {
        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry date cannot be empty");
        }
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}