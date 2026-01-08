public class Product {
    // Required: Minimum 4 protected fields
    protected String name;
    protected double price;
    protected int quantity;
    protected String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product() {
        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;
        this.category = "General";
    }

    // Required: Method to be overridden
    public void performAction() {
        System.out.println("Processing product: " + name);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void restock(int amount) {
        this.quantity += amount;
        System.out.println("Product restocked for: " + name);
    }

    public boolean isInStock() {
        return this.quantity > 0;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}