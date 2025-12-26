public class Customer {
        private String fullName;
        private double totalSpent;
        private int loyaltyPoints;
        private boolean isVip;
        public Customer(String fulName, double totalSpent, int loyaltyPoints) {
            this.fullName = fulName;
            this.totalSpent = totalSpent;
            this.loyaltyPoints = loyaltyPoints;
            this.isVip = totalSpent >50000;
        }
    public Customer() {
        this.fullName = "Unknown";
        this.totalSpent = 0;
        this.loyaltyPoints = 0;
        this.isVip = false;
    }
    public int getLoyaltyPoints() {return loyaltyPoints;}
    public String getFullName() { return fullName; }
    public double getTotalSpent() { return totalSpent; }
    public boolean isVip() { return isVip; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
        checkVipStatus();}

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }


    public void addPoints(int points) {
            this.loyaltyPoints += points;
            System.out.println(" Начислено " + points + " баллов клиенту " + fullName );
    }
    public boolean checkVipStatus(){
            if(this.totalSpent > 100000){
                this.isVip = true;
                return true;
            }
            return this.isVip;
    }

    public String toString() {
            return " Клиент: " + fullName + " баллы: " +loyaltyPoints +" ВИП: " +isVip;
    }
}
