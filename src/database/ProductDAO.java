    package database;
    import java.sql.*;
    public class ProductDAO {
        public void create(String name, double price, int quantity, String category) {
            String sql = "INSERT INTO products (name, price, quantity, category) VALUES (?, ?, ?, ?)";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setDouble(2, price);
                pstmt.setInt(3, quantity);
                pstmt.setString(4, category);

                pstmt.executeUpdate();
                System.out.println("Product saved to db");
            } catch (SQLException e) {
                System.out.println("Database error");
            }
        }

        public void readAll() {
            String sql = "SELECT * FROM products;";
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("=INVENTORY LIST=");
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    System.out.println("ID: " + rs.getInt("product_id") +
                            " | Name: " + rs.getString("name")
                            + " | Category: " + rs.getString("category")
                            + " | Price: " + rs.getDouble("price")
                            + " | Quantity: " + rs.getInt("quantity"));
                }
                if (!hasData) System.out.println("No data found");
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }

        public void update(int id, double newPrice, int newQuantity){
            String sql = "UPDATE products SET price=? ,quantity=? WHERE product_id=?; ";
            try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setDouble(1,newPrice);
                pstmt.setInt(2,newQuantity);
                pstmt.setInt(3,id);
                int rows =pstmt.executeUpdate();
                if(rows>0)System.out.println("Updated product");
                else System.out.println("No updated product");
            }catch(SQLException e){
                System.out.println("Database error: " + e.getMessage());
            }
        }

        public void delete(int id){
            String sql = "DELETE FROM products WHERE product_id=?;";
            try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1,id);
                int rows=pstmt.executeUpdate();
                if(rows>0)System.out.println("Deleted product");
                else System.out.println("No deleted product");
            }catch(SQLException e){
                System.out.println("Database error: " + e.getMessage());
            }
        }

        public void searchByName(String name){
            String sql = "SELECT * FROM products WHERE name LIKE ?;";
            try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql)){
                pstmt.setString(1,"%"+ name +"%");
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    System.out.println("Match found: " + rs.getString("name") + " (Cat: " + rs.getString("category") + ")");
                }
            }catch(SQLException e){
                System.out.println("Database error: " + e.getMessage());
            }
        }
        public void searchByMinPrice(double minPrice) {
            String sql = "SELECT * FROM products WHERE price >= ? ORDER BY price DESC;";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setDouble(1, minPrice);
                ResultSet rs = pstmt.executeQuery();

                System.out.println("=== PRODUCTS PRICED " + minPrice + " AND ABOVE ===");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("ID: " + rs.getInt("product_id") +
                            " | Name: " + rs.getString("name") +
                            " | Price: " + rs.getDouble("price") +
                            " | Qty: " + rs.getInt("quantity"));
                }
                if (!found) {
                    System.out.println("No products found above this price.");
                }
            } catch (SQLException e) {
                System.out.println("Datae error: " + e.getMessage());
            }
        }
    }






































