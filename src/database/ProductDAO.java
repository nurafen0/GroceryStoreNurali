    package database;

    import java.sql.*;

    public class ProductDAO {

        public void create(String name, double price, int qty, String category) {
            String sql = "INSERT INTO products (name, price, quantity, category) VALUES (?, ?, ?, ?);";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, name);
                pstmt.setDouble(2, price);
                pstmt.setInt(3, qty);
                pstmt.setString(4, category);

                pstmt.executeUpdate();
                System.out.println(">> Product saved to database.");
            } catch (SQLException e) {
                System.out.println(">> Database Error (Create): " + e.getMessage());
            }
        }

        public void readAll() {
            String sql = "SELECT * FROM products";
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("\n--- INVENTORY LIST ---");
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    System.out.println("ID: " + rs.getInt("product_id") +
                            " | Name: " + rs.getString("name") +
                            " | Category: " + rs.getString("category") +
                            " | Price: $" + rs.getDouble("price") +
                            " | Qty: " + rs.getInt("quantity"));
                }
                if (!hasData) {
                    System.out.println("(Table is empty)");
                }
            } catch (SQLException e) {
                System.out.println(">> Read Error: " + e.getMessage());
            }
        }

        public void update(int id, double newPrice, int newQty) {
            String sql = "UPDATE products SET price = ?, quantity = ? WHERE product_id = ?;";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, newPrice);
                pstmt.setInt(2, newQty);
                pstmt.setInt(3, id);
                int rows = pstmt.executeUpdate();
                if (rows > 0) System.out.println(">> Update successful.");
                else System.out.println(">> ID not found.");
            } catch (SQLException e) {
                System.out.println(">> Update Error: " + e.getMessage());
            }
        }

        public void delete(int id) {
            String sql = "DELETE FROM products WHERE product_id = ?;";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int rows = pstmt.executeUpdate();
                if (rows > 0) System.out.println(">> Product deleted.");
                else System.out.println(">> ID not found.");
            } catch (SQLException e) {
                System.out.println(">> Delete Error: " + e.getMessage());
            }
        }

        public void searchByName(String name) {
            String sql = "SELECT * FROM products WHERE name ILIKE ?;";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, "%" + name + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Match found: " + rs.getString("name") + " (Cat: " + rs.getString("category") + ")");
                }
            } catch (SQLException e) {
                System.out.println(">> Search Error: " + e.getMessage());
            }
        }
    }