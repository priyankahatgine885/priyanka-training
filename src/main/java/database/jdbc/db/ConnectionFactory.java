package database.jdbc.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static ConnectionFactory instance = new ConnectionFactory();
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "priyanka", "priyanka");
        }
        catch (Exception e) {
            System.out.println("ERROR: Unable to connect to Database");
        }
        return connection;
    }
    public static Connection getConnection() {
        return instance.createConnection();
    }
}