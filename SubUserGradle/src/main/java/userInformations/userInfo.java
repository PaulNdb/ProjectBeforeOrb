package userInformations;
import java.sql.*;

public class userInfo {
    static final String DB_URL = "jdbc:mysql://localhost:3306/userinfo";
    static final String USER = "paul";
    static final String PASS = "paulndb";
    static final String QUERY = "SELECT username, email, password FROM userinfo.user";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Username: " + rs.getString("username"));
                System.out.print(", Email: " + rs.getString("email"));
                System.out.print(", password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
