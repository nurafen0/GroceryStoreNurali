import java.util.ArrayList;

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(" GROCERY STORE MANAGMENT SYSTEM ");

        inventory.add(new Product("Bag", 50.0, 100, "General"));
        inventory.add(new FreshProduct("Apple", 120.0, 50, "Fruits", "2026-01-20"));
        inventory.add(new PackagedProduct("Milk", 450.0, 15, "Dairy", "789456123"));

        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Product p : inventory) {
            p.performAction();
            if (p instanceof FreshProduct) {
                ((FreshProduct) p).checkQuality();
            }
        }
        System.out.println("--------------------------\n");

        Product apple = new Product(" Яблоко ", 120.0, 50, " Фрукты ");
        Product milk = new Product(" Молоко ", 450.0, 0, " Молочные ");
        Customer user1 = new Customer(" Нурали Амангелди ", 60000.0, 100);
        Sale sale1 = new Sale(1001, " Яблоко: ", 1200.0);

        System.out.println(" STORAGE ");
        System.out.println(apple);
        System.out.println(milk);
        System.out.println(" Проверка цены яблока: " + apple.getPrice() + " тг");

        System.out.println(" TEST:Пополнение ");
        milk.restock(15);
        System.out.println(" Теперь есть молоко? " + milk.isInStock());

        System.out.println( "TEST:клиенты" );
        System.out.println(user1);
        user1.addPoints(50);

        System.out.println(" Test:  Продажа ");
        sale1.applyDiscount(10);
        sale1.completeSale();
        System.out.println(" Итоги продажи: " + sale1);
    }
}

class Product {
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

    public void performAction() {
        System.out.println("Processing general product: " + name);
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

class FreshProduct extends Product {
    private String expiryDate;

    public FreshProduct(String name, double price, int quantity, String category, String expiryDate) {
        super(name, price, quantity, category);
        this.expiryDate = expiryDate;
    }

    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + ". Expiring: " + expiryDate);
    }

    public void checkQuality() {
        System.out.println(">>> Quality Control: " + name + " is fresh.");
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + " [Exp: " + expiryDate + "]";