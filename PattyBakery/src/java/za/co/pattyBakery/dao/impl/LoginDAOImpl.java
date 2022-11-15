package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.pattyBakery.dao.LoginDAO;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoginDAOImpl implements LoginDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection con = null;

    public LoginDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public LoginDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addCustomerLogins(Integer customerId, String email, String password) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO login VALUES (?,?,?);");
                preparedStatement.setInt(1, customerId);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void removeCustomerLogins(Integer customerId, String email) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE  FROM login WHERE id = ? AND email=?");
                preparedStatement.setInt(1, customerId);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }

    }

    public String getCustomerPassword(Integer customerId, String email) {
        String password = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM login WHERE email = ? AND id=?");
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, customerId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    password = resultSet.getString("password");
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return password;
    }
}
