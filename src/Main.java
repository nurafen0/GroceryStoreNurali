import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new PackagedProduct("Banana", 12.50, 50, "Fruit", "BAR-99821"));
        inventory.add(new FreshProduct("Chicken", 25.00, 10, "meat", "2026-01-15"));
        inventory.add(new PackagedProduct("Coca-cola", 1.20, 100, "Soda drink", "BAR-00123"));

        System.out.println("=== GROCERY STORE MANAGEMENT SYSTEM (WEEK 4) ===");
        System.out.println("Demonstrating Polymorphism & Downcasting:\n");

        for (Product p : inventory) {
            p.performAction();

            System.out.println("Details: " + p.toString());

            if (p instanceof PackagedProduct) {
                PackagedProduct pp = (PackagedProduct) p;
                pp.printLabel();
            }
            else if (p instanceof FreshProduct) {
                FreshProduct fp = (FreshProduct) p;
                fp.checkQuality();
            }
            System.out.println("-----------------------------------\n");
        }

        System.out.println("=== ORIGINAL SYSTEM TESTS ===");

        Product apple = new Product(" Яблоко ", 120.0, 50, " Фрукты ");
        Product milk = new Product(" Молоко ", 450.0, 0, " Молочные ");

        Customer user1 = new Customer(" Нурали Амангелди ", 60000.0, 100);
        Sale sale1 = new Sale(1001, " Яблоко: ", 1200.0);

        System.out.println(" STORAGE ");
        System.out.println(apple);
        System.out.println(milk);

        System.out.println(" Проверка цены яблока: " + apple.getPrice() + " тг");

        System.out.println(" TEST: Пополнение ");
        System.out.println(" Есть ли молоко? " + milk.isInStock());
        milk.restock(15);
        System.out.println(" Теперь есть молоко? " + milk.isInStock());

        System.out.println(" TEST: Клиенты ");
        System.out.println(user1);
        user1.addPoints(50);
        System.out.println(" Обновленный клиент: " + user1);

        System.out.println(" TEST: Продажа ");
        System.out.println(sale1);
        sale1.applyDiscount(10);
        sale1.completeSale();
        System.out.println(" Итоги продажи: " + sale1);
    }
}