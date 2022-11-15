package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.dao.CustomerDAO;
import za.co.pattyBakery.model.PersonImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CustomerDAOImpl implements CustomerDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection con = null;

    public CustomerDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public CustomerDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addCustomer(Person customer) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO customer (name, surname,idNum,tel, email, address) VALUES(?,?,?,?,?,?);");
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getIdNumber());
                preparedStatement.setString(4, customer.getTelephoneNumber());
                preparedStatement.setString(5, customer.getEmail());
                preparedStatement.setString(6, customer.getDeliveryAddress());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);
        }

    }

    @Override
    public Person getCustomerById(Integer customerId) {
        Person customer = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM customer WHERE cust_id = ?");
                preparedStatement.setInt(1, customerId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    customer = new PersonImpl(resultSet.getInt("cust_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("idNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"));
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return customer;
    }

    @Override
    public Person getCustomerByEmail(String email) {
        Person customer = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM customer WHERE email = ?");
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    customer = new PersonImpl(resultSet.getInt("cust_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("idNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"));
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return customer;
    }

    @Override
    public void removeCustomer(Integer customerId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE  FROM customer WHERE cust_id = ?");
                preparedStatement.setInt(1, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateCustomerTel(Integer customerId, String tel) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE customer SET  tel =?  WHERE cust_id = ?");
                preparedStatement.setString(1, tel);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateCustomerEmail(Integer customerId, String email) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE customer SET  email =?  WHERE cust_id = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateCustomerAddress(Integer customerId, String address) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE customer SET  address =?  WHERE cust_id = ?");
                preparedStatement.setString(1, address);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public List<Person> getAllCustomers() {
        List<Person> customers = new ArrayList<>();
        Person customer = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM customer;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new PersonImpl(resultSet.getInt("cust_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("idNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"));
                    customers.add(customer);
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return customers;
    }

}
