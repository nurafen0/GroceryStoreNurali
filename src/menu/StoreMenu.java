package menu;

import model.*;
import exception.InvalidInputException;
import java.util.*;

public class StoreMenu implements Menu {
    private List<Product> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        inventory.add(new FreshProduct("Milk", 450, 20, "2024-05-10"));
        inventory.add(new FreshProduct("Apple", 800, 50, "2024-06-01"));
        inventory.add(new PackagedProduct("Chips", 1200, 15, "8601234567"));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- GROCERY STORE SYSTEM ---");
        System.out.println("1. Add Fresh Product");
        System.out.println("2. Show Full Inventory");
        System.out.println("3. View by Category"); // NEW
        System.out.println("4. Search Product Details"); // NEW
        System.out.println("5. Run Freshness Check (Polymorphism)");
        System.out.println("6. Apply Discounе процент");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            System.out.print("Choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addFreshProduct();
                    case 2 -> showInventory();
                    case 3 -> viewByCategory(); // NEW
                    case 4 -> viewProductDetails(); // NEW
                    case 5 -> runCheck();
                    case 6 -> applyDiscount();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) { // Handling inputs gracefully [cite: 351]
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }

    // --- NEW VIEW METHODS ---

    /**
     * Demonstrates using the abstract getCategory() method to filter inventory.
     */
    private void viewByCategory() {
        System.out.print("Enter category (Fresh Product / Packaged Product): ");
        String category = scanner.nextLine();
        boolean found = false;

        System.out.println("\n--- Results for: " + category + " ---");
        for (Product p : inventory) {
            // Polymorphic call to getCategory() [cite: 358]
            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("No products found in this category.");
    }

    /**
     * Searches for a product by name and displays detailed info using getters.
     */
    private void viewProductDetails() {
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Product p : inventory) {
            if (p.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\n--- Product Details ---");
                System.out.println("Name: " + p.getName());
                System.out.println("Category: " + p.getCategory());
                System.out.println("Price: " + p.getPrice() + " KZT");
                p.performAction(); // Shows specific behavior (scanning or freshness)
                found = true;
                break;
            }
        }
        if (found) System.out.println("Product not found.");
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
        System.out.println("\n--- Current Inventory ---");
        for (Product p : inventory) System.out.println(p);
    }

    private void runCheck() {
        System.out.println("\n--- Running System Actions ---");
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