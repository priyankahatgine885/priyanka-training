package database.jdbc.dao;
import database.jdbc.db.ConnectionFactory;
import database.model.Canteen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static database.jdbc.db.DbUtil.close;


public class CanteenDao {
    private Connection connection;
    private Statement statement;
    Canteen canteen = null;

    public void createDatabase() throws Exception {
        String sql = "CREATE DATABASE canteen_db";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void createTableOfCanteen() throws Exception {
        String sql = "CREATE TABLE canteens " +
                "(canteen_id INTEGER , " +
                " canteen_name VARCHAR(255), " +
                " canteen_type VARCHAR(255), " +
                " canteen_bill VARCHAR(255), " +
                " canteen_empId INTEGER, " +
                " PRIMARY KEY ( canteen_id ))";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Canteen getById(int canteenId) throws SQLException {
        String query = "SELECT * FROM customer  WHERE customer_id=" +canteenId;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int canteen_id = rs.getInt("canteen_id");
                String canteen_name = rs.getString("canteen_name");
                String canteen_type = rs.getString("canteen_type");
                String canteen_bill = rs.getString("canteen_bill");
                int canteen_empId = rs.getInt("canteen_empId");
                canteen = new Canteen(canteen_id, canteen_name, canteen_type, canteen_bill, canteen_empId);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return canteen;
    }

    public List<Canteen> getAll() {
        List<Canteen> canteenList = new ArrayList<>();
        String query = "select * from canteen";
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int canteen_id = rs.getInt("canteen_id");
                String canteen_name = rs.getString("canteen_name");
                String canteen_type = rs.getString("canteen_type");
                String canteen_bill = rs.getString("canteen_bill");
                int canteen_empId = rs.getInt("canteen_empId");
                canteen = new Canteen(canteen_id, canteen_name, canteen_type, canteen_bill, canteen_empId);
                canteenList.add(canteen);
            }
            close(connection);
            System.out.println("close connection");
        } catch (Exception e) {
            System.out.println(e);
        }
        return canteenList;
    }

    public Canteen insert(Canteen canteen) throws Exception {
        try {
            System.out.println("Connecting to a selected database...");
            connection = ConnectionFactory.getConnection();
            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
            String query = "INSERT INTO canteens(canteen_id, canteen_name, canteen_type, canteen_bill, canteen_empId)" + " VALUES (" + canteen.getCanteen_id() + ", '" + canteen.getCanteen_name() + "', '" + canteen.getCanteen_type() + "', '" + canteen.getCanteen_bill() + "', " + canteen.getCanteen_empId()  + "" + ");";
            statement.execute(query);
            close(connection);
        } catch (Exception e) {
            System.out.println(e);
        }
        return canteen;
    }

    public Canteen update(Canteen canteen) {
        String query = "update canteen " + "set canteen_name = 'ajay' where canteen_id =" + canteen.getCanteen_id();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root", "root");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println("Number of records affected :: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }

        return canteen;
    }

    public Canteen remove(Canteen canteen) {
        String query = "delete from customer where customer_id =" + canteen.getCanteen_id();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root", "root");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println("Number of records affected :: " + result);
            close(connection);
            close(statement);
        } catch (Exception e) {
            System.out.println(e);
        }
        return canteen;
    }
}
