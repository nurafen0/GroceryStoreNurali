package menu;

import database.ProductDAO;
import exception.InvalidInputException;
import java.util.Scanner;

public class StoreMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ProductDAO dao = new ProductDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n--- GROCERY STORE SYSTEM ---");
        System.out.println("1. Add Product to Database");
        System.out.println("2. Show DB Inventory");
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
                    case 1 -> addProductToDB();
                    case 2 -> dao.getAllProducts();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addProductToDB() throws InvalidInputException {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Category: ");
            String category = scanner.nextLine();

            dao.insertProduct(name, price, category);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Price must be a number!");
        }
    }
}