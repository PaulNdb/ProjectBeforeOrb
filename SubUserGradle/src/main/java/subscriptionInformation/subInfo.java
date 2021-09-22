package subscriptionInformation;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class subInfo {
    static final String DB_URL = "jdbc:mysql://localhost:3306/subinfo";
    static final String USER = "paul";
    static final String PASS = "paulndb";
    static final String QUERY = "SELECT * FROM subinfo.subscription";


    public static void subName(){
        Scanner nameSub = new Scanner(System.in);
        System.out.println("Do you want the list of subscribers ?[Y]:yes [N]:no");
        String str = nameSub.next();
            if (Objects.equals(str, "Y")){
                //show the list of subscribers only
                //ask if this table need to be edit
                //if yes, ask if it's someone to add or to delete or quit
                //add: prompt the name (only this at the moment)
                //delete: prompt the name to delete

            }
            if (Objects.equals(str, "N")){
                //don't show the list and cancel
            }
    }

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name

                System.out.println(", Selected: " + rs.getString("selected"));
                System.out.println(", Price: " + rs.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
