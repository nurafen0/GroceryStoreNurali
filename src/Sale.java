public class Sale {
    private int saleId;
    private String productName;
    private double amount;
    private String status;

    public Sale(int saleId, String productName, double amount) {
        this.saleId = saleId;
        this.productName = productName;
        this.amount = amount;
        this.status =" Ожидание ";
    }

    public int getSaleId() { return saleId; }
    public String getProductName() { return productName; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }


    public void setSaleId(int saleId) { this.saleId = saleId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setAmount(double amount) { this.amount = amount; }



    public void applyDiscount(double percent) {
        this.amount -= this.amount * (percent / 100);
        System.out.println(" Скидка "+ percent + " к чеку под номером "+ saleId);
    }

    public void completeSale(){
        this.status = " Оплачено ";
    }

    public String toString() {
        return " Чек номер- " + saleId + " товар " + productName + " Итого: " + amount + " Статус: " + status;
    }
}
