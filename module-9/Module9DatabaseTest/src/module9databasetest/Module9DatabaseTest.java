package module9databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Tiffany Davidson
 * Module 9.2 Assignment
 * CSD420
 *
 * This program tests the Java connection to the MySQL database required
 * for Module 9.2. It connects to the databasedb database using the
 * student1 user account and prints records from the address33 table.
 */
public class Module9DatabaseTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3307/databasedb?useSSL=false&serverTimezone=UTC";
        String user = "student1";
        String password = "pass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection successful!");
            System.out.println("Connected to database: databasedb");
            System.out.println("Connected as user: student1");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM address33");

            System.out.println();
            System.out.println("Records from address33:");
            System.out.println("ID | First Name | Last Name | Street | City | State | ZIP");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String lastName = resultSet.getString("LASTNAME");
                String firstName = resultSet.getString("FIRSTNAME");
                String street = resultSet.getString("STREET");
                String city = resultSet.getString("CITY");
                String state = resultSet.getString("STATE");
                String zip = resultSet.getString("ZIP");

                System.out.println(id + " | " + firstName + " | " + lastName + " | "
                        + street + " | " + city + " | " + state + " | " + zip);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println();
            System.out.println("Database test completed successfully.");

        } catch (Exception e) {
            System.out.println("Database connection failed.");
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}