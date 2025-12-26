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
        public String getFulName() {return fullName;}
    public int getLoyaltyPoints() {return loyaltyPoints;}

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
