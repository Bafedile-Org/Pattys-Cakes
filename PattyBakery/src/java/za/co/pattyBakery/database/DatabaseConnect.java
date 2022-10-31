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
        String url = "jdbc:mysql://localhost:3306/patty_bakery?useSSL=false";

        try {
            con = DriverManager.getConnection(url, "mecer", "mecer");
        } catch (SQLException sql) {
            System.out.println("Failed to Connect...." + sql.getMessage());
        }
        System.out.println("Connection Achieved.");
        CustomerTable();
    }

    public void CustomerTable() {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("CREATE TABLE customer (cust_id INTEGER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20),surname VARCHAR(20),idNum VARCHAR(13),tel VARCHAR(20),email VARCHAR(20),address VARCHAR(20))");
            stat.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Failed to create customer table.." + sql.getMessage());
        }
    }
}
/**
 *
 * private void addJokeDatabase(Jokes joke) { PreparedStatement stat = null; try
 * { stat = con.prepareStatement("Insert into momdadjokes (cat_id,joke) values
 * (?,?)"); stat.setInt(1, joke.getCategory()); stat.setString(2,
 * joke.getJoke()); stat.executeUpdate(); } catch (SQLException sql) {
 * System.out.println("Error : " + sql.getMessage()); } }
 *
 */
