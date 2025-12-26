public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product() {
        this.name = " Unknowт ";
        this.price = 0;
        this.quantity = 0;
        this.category = " general ";
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getQuantity() {return quantity;}
    public String getCategory() {return category;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}



    public void setPrice(double price) {this.price = price;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public void restock(int amount){
        this.quantity += amount;
        System.out.println(" Product restocked for: "+ name );
    }
    public boolean isInStock() {
        return this.quantity > 0;
    }
    public String toString() {
        return " Product Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}
