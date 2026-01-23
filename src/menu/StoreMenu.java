package menu;

import model.*;
import exception.InvalidInputException;
import java.util.*;

public class StoreMenu implements Menu {
    private List<Product> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        // Тестовые данные
        inventory.add(new FreshProduct("Milk", 450, 20, "2024-05-10"));
        inventory.add(new FreshProduct("Apple", 800, 50, "2024-06-01"));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- GROCERY STORE SYSTEM ---");
        System.out.println("1. Add Fresh Product");
        System.out.println("2. Show Inventory");
        System.out.println("3. Run Freshness Check (Polymorphism)");
        System.out.println("4. Apply Discount");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addFreshProduct();
                    case 2 -> showInventory();
                    case 3 -> runCheck();
                    case 4 -> applyDiscount();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }

    private void addFreshProduct() throws InvalidInputException {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            inventory.add(new FreshProduct(name, price, 10, date));
            System.out.println(" Product added!");
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Price must be a number!");
        }
    }

    private void showInventory() {
        for (Product p : inventory) System.out.println(p);
    }

    private void runCheck() {
        for (Product p : inventory) p.performAction();
    }

    private void applyDiscount() {
        System.out.print("Enter discount %: ");
        double d = Double.parseDouble(scanner.nextLine());
        for (Product p : inventory) {
            if (p instanceof Discountable dist) {
                dist.applyDiscount(d);
                System.out.println("New price for " + p.getName() + ": " + p.getPrice());
            }
        }
    }
}