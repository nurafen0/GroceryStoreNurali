public class PackagedProduct extends Product {
    private String barcode;

    public PackagedProduct(String name, double price, int quantity, String category, String barcode) {
        super(name, price, quantity, category);
        this.barcode = barcode;
    }

    @Override
    public void performAction() { // Override 1
        System.out.println("Scanning barcode [" + barcode + "] for: " + name);
    }

    @Override
    public void restock(int amount) { // Override 2
        super.restock(amount);
        System.out.println("System updated for barcode: " + barcode);
    }

    // Unique Method 1 [cite: 128]
    public void printLabel() {
        System.out.println("Printing shipping label for " + name);
    }

    // Unique Method 2 [cite: 128]
    public String getBarcode() { return barcode; }
}