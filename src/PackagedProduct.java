public class PackagedProduct extends Product {
    private String barcode;

    public PackagedProduct(String name, double price, int quantity, String category, String barcode) {
        super(name, price, quantity, category);
        this.barcode = barcode;
    }

    @Override
    public void performAction() {
        System.out.println("Scanning barcode [" + barcode + "] for packaged item: " + name);
    }

    @Override
    public String getCategory() {
        return "Packaged " + category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void verifySeal() {
        System.out.println("Safety seal for " + name + " is intact.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Barcode: " + barcode + "]";
    }
}