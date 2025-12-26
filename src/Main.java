    public class Main {
        public static void main(String[] args) {
            System.out.println(" GROCERY STORE MANAGMENT SYSTEM ");

            Product apple = new Product(" Яблоко ",120.0, 50, " Фрукты ");
            Product milk = new Product(" Молоко ", 450.0, 0, " Молочные ");
            Customer user1 = new Customer(" Нурали Амангелди ", 60000.0, 100);
            Sale sale1 = new Sale(1001, " Яблоко: ", 1200.0);

            System.out.println(" STORAGE ");
            System.out.println(apple);
            System.out.println(milk);

            System.out.println(" Проверка цены яблока: " + apple.getPrice() + " тг");

            System.out.println(" TEST:Пополнение ");
            System.out.println(" Есть ли молоко? "+ milk.isInStock());
            milk.restock(15);
            System.out.println(" Теперь есть молоко? " + milk.isInStock());

            System.out.println( "TEST:клиенты" );
            System.out.println(user1);
            user1.addPoints(50);
            System.out.println( " Обновленный клиент: "+ user1);

            System.out.println(" Test:  Продажа ");
            System.out.println(sale1);
            sale1.applyDiscount(10);
            sale1.completeSale();
            System.out.println(" Итоги продажи: " + sale1);


        }
    }