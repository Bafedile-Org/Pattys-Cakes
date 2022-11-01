package za.co.pattyBakery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bridget Bapela
 */
public class DatabaseConnect {

    Connection con = null;

    public DatabaseConnect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found");
            return;
        }
        String url = "jdbc:mysql://localhost:3306/?useSSL=false";

        try {
            con = DriverManager.getConnection(url, "mecer", "mecer");
            createDatabase();
        } catch (SQLException sql) {
            System.out.println("Failed to Connect...." + sql.getMessage());
        }
        System.out.println("Connection Achieved.");
        CustomerTable();
        EmployeeTable();
        IngredientsTable();
        NutrientsTable();
        CategoryTable();
        ProductTable();
        StockTable();
        OrderTable();
        TotalOrderTable();
    }

    public void createDatabase() {
        PreparedStatement stat = null;
        try {
            con.prepareStatement("CREATE DATABASE IF NOT EXISTS pattyBakery").executeUpdate();
            con.prepareStatement("USE pattyBakery").executeUpdate();

        } catch (SQLException ex) {

        }
    }

    public void CustomerTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer (cust_id INTEGER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20),"
                    + "surname VARCHAR(20),idNum VARCHAR(13),tel VARCHAR(20),email VARCHAR(20),address VARCHAR(20))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create customer table.." + sql.getMessage());
        }
        System.out.println("Customer table created");
    }

    public void EmployeeTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS employee (emp_id INTEGER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20),"
                    + "surname VARCHAR(20),idNum VARCHAR(13),tel VARCHAR(20),email VARCHAR(20),address VARCHAR(20),title VARCHAR(20))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create employee table.." + sql.getMessage());
        }
        System.out.println("Employee table created");
    }

    public void ProductTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS product (prod_id VARCHAR(10) PRIMARY KEY,nutr_id VARCHAR(10) NOT NULL ,"
                    + "ingr_id VARCHAR(10) NOT NULL ,cat_id VARCHAR(10) NOT NULL REFERENCES category(cat_id),"
                    + "FOREIGN KEY(nutr_id) REFERENCES nutrients(nutr_id),FOREIGN Key(ingr_id) REFERENCES ingredients(ingr_id))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create product table.." + sql.getMessage());
        }
        System.out.println("Product table created");
    }

    public void IngredientsTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS ingredients (ingr_id VARCHAR(10) PRIMARY KEY,"
                    + "ingredient VARCHAR(100),quantity INTEGER(50))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create ingredients table.." + sql.getMessage());
        }
        System.out.println("Ingredients table created");
    }

    public void NutrientsTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS nutrients (nutr_id VARCHAR(10) PRIMARY KEY,nutrient VARCHAR(100))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create nutrient table.." + sql.getMessage());
        }
        System.out.println("Nutrient table created");
    }

    public void CategoryTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS category (cat_id INTEGER AUTO_INCREMENT PRIMARY KEY,category VARCHAR(100))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create category table.." + sql.getMessage());
        }
        System.out.println("Category table created");
    }

    public void OrderTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS orders (order_id VARCHAR(10) PRIMARY KEY,prod_id VARCHAR(10) NOT NULL ,quantity INTEGER,delivered BOOLEAN,date DATE,FOREIGN KEY(prod_id) REFERENCES product(prod_id))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create order table.." + sql.getMessage());
        }
        System.out.println("Order table created");
    }

    public void TotalOrderTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS total_orders (order_id VARCHAR(10) NOT NULL ,"
                    + "totalAmount DOUBLE,FOREIGN KEY(order_id) REFERENCES orders(order_id))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create totalOrder table.." + sql.getMessage());
        }
        System.out.println("TotalOrder table created");
    }

    public void StockTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS stock (prod_id VARCHAR(10) NOT NULL,"
                    + "quanity INTEGER(255),FOREIGN KEY(prod_id) REFERENCES product(prod_id))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create Stock table.." + sql.getMessage());
        }
        System.out.println("Stock table created");
    }
}
