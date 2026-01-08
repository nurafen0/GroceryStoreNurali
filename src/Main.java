import java.util.ArrayList;

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(" GROCERY STORE MANAGMENT SYSTEM ");

        // Week 4 Polymorphism Section
        inventory.add(new Product("Bag", 50.0, 100, "General"));
        inventory.add(new FreshProduct("Apple", 120.0, 50, "Fruits", "2026-01-20"));
        inventory.add(new PackagedProduct("Milk", 450.0, 15, "Dairy", "789456123"));

        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Product p : inventory) {
            p.performAction();
            if (p instanceof FreshProduct) {
                // This will now work because we added checkQuality() to FreshProduct.java
                ((FreshProduct) p).checkQuality();
            }
        }
        System.out.println("--------------------------\n");

        // Your original test code (Unchanged)
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