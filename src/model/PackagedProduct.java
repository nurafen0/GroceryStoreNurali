package model;

public class PackagedProduct extends Product {
    private String barcode;

    public PackagedProduct(String name, double price, int quantity, String barcode) {
        super(name, price, quantity);

        setBarcode(barcode);
    }

    @Override
    public String getCategory() {
        return "Packaged Product";
    }

    @Override
    public void performAction() {
        System.out.println("Scanning barcode: " + barcode + " for " + name);
    }

    public void setBarcode(String barcode) {
        if (barcode == null || barcode.trim().isEmpty()) {
            throw new IllegalArgumentException("Barcode cannot be empty");
        }
        this.barcode = barcode;
    }
}