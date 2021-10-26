package database.jdbc.dao;
import database.jdbc.db.ConnectionFactory;
import database.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.jdbc.db.DbUtil.close;

public class CustomerDao {
    private Connection connection;
    private Statement statement;
    Customer customer = null;

    public Customer getById(int customerId) throws SQLException {
        String query = "SELECT * FROM customer  WHERE customer_id=" + customerId;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                customer = new Customer(customer_id, customer_name);
            }
            close(connection);
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        String query = "select * from customer";
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                customer = new Customer(customer_id, customer_name);
                customerList.add(customer);
            }
            close(connection);
            System.out.println("close connection");
        } catch (Exception e) {
            System.out.println(e);
        }
        return customerList;
    }

    public Customer insert(Customer customer) throws Exception {
        try {
            System.out.println("Connecting to a selected database...");
            connection = ConnectionFactory.getConnection();
            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
            String query = "INSERT INTO customer(customer_id, customer_name)" + " VALUES (" + customer.getCustomer_id() + ", '" + customer.getCustomer_name() + "'" + ");";
            statement.execute(query);
            close(connection);
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    public Customer update(Customer customer) {
        String query = "update customer " + "set customer_name = 'ajay' where customer_id =" + customer.getCustomer_id();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_db", "root", "root");
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println("Number of records affected :: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public Customer remove(Customer customer) {
        String query = "delete from customer where customer_id =" + customer.getCustomer_id();
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
        return customer;
    }
}
