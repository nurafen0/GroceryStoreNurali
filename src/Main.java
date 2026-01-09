import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- GROCERY STORE MANAGEMENT ---");
            System.out.println("1. Add General Product");
            System.out.println("2. Add Packaged Product");
            System.out.println("3. Add Fresh Product");
            System.out.println("4. View All Inventory");
            System.out.println("5. Process Products (Polymorphism)");
            System.out.println("6. View Fresh Products (instanceof)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String n1 = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double p1 = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int q1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String c1 = scanner.nextLine();

                    inventory.add(new Product(n1, p1, q1, c1));
                    System.out.println("Added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String n2 = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double p2 = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int q2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String c2 = scanner.nextLine();
                    System.out.print("Enter Barcode: ");
                    String b2 = scanner.nextLine();

                    inventory.add(new PackagedProduct(n2, p2, q2, c2, b2));
                    System.out.println("Packaged Product added!");
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String n3 = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double p3 = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int q3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String c3 = scanner.nextLine();
                    System.out.print("Enter Expiry Date: ");
                    String e3 = scanner.nextLine();

                    inventory.add(new FreshProduct(n3, p3, q3, c3, e3));
                    System.out.println("Fresh Product added!");
                    break;

                case 4:
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty!");
                    } else {
                        for (Product p : inventory) {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 5:
                    for (Product p : inventory) {
                        p.performAction();
                    }
                    break;

                case 6:
                    for (Product p : inventory) {
                        if (p instanceof FreshProduct) {
                            System.out.println(p.toString());
                            ((FreshProduct) p).checkQuality();
                        }
                    }
                    break;
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }
}