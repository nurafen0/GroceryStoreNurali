package model;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty!");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract void performAction(); // Полиморфный метод
    public abstract String getCategory();

    @Override
    public String toString() {
        return "[" + getCategory() + "] " + name + " | Price: " + price + " KZT | Qty: " + quantity;
    }
}