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

    static Connection con = null;
    private static DatabaseConnect dbCon;

    static {
        dbCon = new DatabaseConnect();
    }

    private DatabaseConnect() {
        connect();
    }

    public void connect() {
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
        RecipeTable();
        RecipeIngredientTable();
        ProductTable();
        StockTable();
        OrderTable();
        TotalOrderTable();
        createLoginTable();
        createEmployeeLoginTable();
        ProductNutrientsTable();

        PopulateValues p = new PopulateValues(con);
        p.addAll();
    }

    public static DatabaseConnect getInstance() {
        return dbCon;
    }

    public Connection getConnection() {
//        connect();
        return con;
    }

    private static void createDatabase() {
        PreparedStatement stat;
        try {
            con.prepareStatement("CREATE DATABASE IF NOT EXISTS pattyBakery").executeUpdate();
            con.prepareStatement("USE pattyBakery").executeUpdate();

        } catch (SQLException ex) {

        }
    }

    private static void createLoginTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS login (id INTEGER NOT NULL PRIMARY KEY,email VARCHAR(255) NOT NULL UNIQUE KEY, password VARCHAR(40) NOT NULL,"
                    + " FOREIGN KEY(id) REFERENCES customer(cust_id))").executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create login table.." + sql.getMessage());
        }
    }

    private static void createEmployeeLoginTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS employee_login (id INTEGER NOT NULL PRIMARY KEY,email VARCHAR(255) NOT NULL UNIQUE KEY, password VARCHAR(40) NOT NULL,"
                    + " FOREIGN KEY(id) REFERENCES employee(emp_id))").executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create login table.." + sql.getMessage());
        }
    }

    private static void CustomerTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer (cust_id INTEGER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20),"
                    + "surname VARCHAR(20),idNum VARCHAR(13) UNIQUE KEY,tel VARCHAR(20),email VARCHAR(255),address VARCHAR(20))");
            stat.executeUpdate();
            System.out.println("Customer table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create customer table.." + sql.getMessage());
        }
    }

    private static void EmployeeTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS employee (emp_id INTEGER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20),"
                    + "surname VARCHAR(20),idNum VARCHAR(13) UNIQUE KEY,tel VARCHAR(20),email VARCHAR(255),address VARCHAR(20),title VARCHAR(20))");
            stat.executeUpdate();
            System.out.println("Customer table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create employee table.." + sql.getMessage());
        }
    }

    private static void ProductTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS product (prod_id VARCHAR(10) PRIMARY KEY,prod_name VARCHAR(200),price Double, nutr_id VARCHAR(10) NOT NULL ,"
                    + "recp_id VARCHAR(10) NOT NULL ,cat_id INTEGER NOT NULL,image_name VARCHAR(255),"
                    + "FOREIGN KEY(nutr_id) REFERENCES nutrients(nutr_id),FOREIGN Key(recp_id) REFERENCES recipe(recp_id),FOREIGN KEY(cat_id)  REFERENCES category(cat_id))");
            stat.executeUpdate();
            System.out.println("Product table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create product table.." + sql.getMessage());
        }
    }

    private static void IngredientsTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS ingredients (ingr_id VARCHAR(10) PRIMARY KEY,"
                    + "ingredient VARCHAR(100),quantity INTEGER(50))");
            stat.executeUpdate();
            System.out.println("Ingredients table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create ingredients table.." + sql.getMessage());
        }
    }

    private static void RecipeIngredientTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS recipe_ingredient (recp_id VARCHAR(10) ,"
                    + "ingr_id VARCHAR(10),FOREIGN KEY(recp_id) REFERENCES recipe(recp_id),FOREIGN KEY(ingr_id) REFERENCES ingredients(ingr_id),PRIMARY KEY(recp_id,ingr_id))");
            stat.executeUpdate();
            System.out.println("Recipe_Ingredients table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create recipe_ingredients table.." + sql.getMessage());
        }
    }

    private static void RecipeTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS recipe (recp_id VARCHAR(10) PRIMARY KEY,"
                    + "descriptions VARCHAR(200))");
            stat.executeUpdate();
            System.out.println("Recipe table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create recipe table.." + sql.getMessage());
        }
    }

    private static void ProductNutrientsTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS product_nutrient (prod_id VARCHAR(10) ,"
                    + "nutr_id VARCHAR(10),grams VARCHAR(105),FOREIGN KEY(prod_id) REFERENCES product(prod_id),FOREIGN KEY(nutr_id) REFERENCES nutrients(nutr_id),PRIMARY KEY(nutr_id,prod_id))");
            stat.executeUpdate();
            System.out.println("Product_Nutrients table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create product_nutrient table.." + sql.getMessage());
        }
    }

    private static void NutrientsTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS nutrients (nutr_id VARCHAR(10) PRIMARY KEY,nutrient VARCHAR(100))");
            stat.executeUpdate();
            System.out.println("Nutrient table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create nutrient table.." + sql.getMessage());
        }
    }

    private static void CategoryTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS category (cat_id INTEGER PRIMARY KEY,category VARCHAR(100))");
            stat.executeUpdate();
            System.out.println("Category table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create category table.." + sql.getMessage());
        }
    }

    private static void OrderTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS orders (order_id VARCHAR(10) ,prod_id VARCHAR(10) NOT NULL ,"
                    + "quantity INTEGER,delivered BOOLEAN,date DATE,FOREIGN KEY(prod_id) REFERENCES product(prod_id),PRIMARY KEY(order_id,prod_id))");
            stat.executeUpdate();
            System.out.println("Order table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create order table.." + sql.getMessage());
        }
    }

    private static void TotalOrderTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS total_orders (order_id VARCHAR(10) NOT NULL ,"
                    + "totalAmount DOUBLE,FOREIGN KEY(order_id) REFERENCES orders(order_id))");
            stat.executeUpdate();
            System.out.println("TotalOrder table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create totalOrder table.." + sql.getMessage());
        }
    }

    private static void StockTable() {
        PreparedStatement stat;
        try {
            stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS stock (prod_id VARCHAR(10) NOT NULL PRIMARY KEY,"
                    + "quantity INTEGER(255),FOREIGN KEY(prod_id) REFERENCES product(prod_id))");
            stat.executeUpdate();
            System.out.println("Stock table created");
        } catch (SQLException sql) {
            System.out.println("Failed to create Stock table.." + sql.getMessage());
        }
    }
}
