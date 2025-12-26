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
