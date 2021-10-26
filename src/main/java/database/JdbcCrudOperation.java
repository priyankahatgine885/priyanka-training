package database;
import database.jdbc.dao.CanteenDao;
import database.jdbc.dao.CustomerDao;
import database.jdbc.db.ConnectionFactory;
import database.model.Canteen;
import database.model.Customer;

public class JdbcCrudOperation {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.createConnection();
        System.out.println("Connected database successfully...");
        //customerCrudExample();
        canteenCrudExample();
    }
    public static void customerCrudExample() throws Exception {
        CustomerDao customerDao = new CustomerDao();
//            Customer customer1 = customerDao.insert(new Customer(1, "anita"));
//            Customer customer2 = customerDao.insert(new Customer(2, "parth"));
//            Customer customer3 = customerDao.insert(new Customer(3, "pratik"));
//            System.out.println(customer1);
//            System.out.println(customer2);
//            System.out.println(customer3);
        Customer customer3 = customerDao.insert(new Customer(4, "sonali"));
        System.out.println(customer3);
        System.out.println("------------------------------");
//            Customer customer4 = customerDao.getById(1);
//            System.out.println(customer4);
//            System.out.println("----------------------------------");
//            List<Customer> customerList = customerDao.getAll();
//            for (Customer customers : customerList) {
//                System.out.println(customers);
//            }
//            Customer customer5 = customerDao.update(new Customer(2, "ajay"));
//            System.out.println(customer5);
//            Customer customer6 = customerDao.remove(new Customer(2, "ajay"));
//            System.out.println(customer6);
    }

    public static void canteenCrudExample() throws Exception {
        CanteenDao canteenDao = new CanteenDao();
       // canteenDao.createDatabase();
        //canteenDao.createTableOfCanteen();
        Canteen canteen1 = canteenDao.insert(new Canteen(1, "Sayaji canteen", "abcd", "1200", 11 ));
        System.out.println(canteen1);
//        System.out.println("------------------------------");
//        Canteen canteen2 = canteenDao.getById(1);
//        System.out.println(canteen2);
//        System.out.println("----------------------------------");
//        List<Canteen> canteenList = canteenDao.getAll();
//        for (Canteen canteen : canteenList) {
//            System.out.println(canteen);
//        }
//        Canteen canteen = canteenDao.update(new Canteen(1, "Pratik canteen", "abcd", "1200", 1));
//        System.out.println(canteen);
//        Canteen canteen3 = canteenDao.remove(new Canteen(2, "ajay"));
//        System.out.println(canteen3);
    }
}
