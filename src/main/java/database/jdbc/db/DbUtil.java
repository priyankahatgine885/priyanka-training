package database.jdbc.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

