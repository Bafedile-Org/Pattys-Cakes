package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.Person;
import za.co.pattybakery.dao.CustomerDAO;
import za.co.pattybakery.model.PersonImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CustomerDAOImpl implements CustomerDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection conn = null;

    public CustomerDAOImpl() {

    }

    @Override
    public void addCustomer(Person customer) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO customer (name, surname,identityNum,tel, email, address) VALUES(?,?,?,?,?,?);");
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
        }

    }

    @Override
    public Person getCustomerById(Integer customerId) {
        Person customer = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
                preparedStatement.setInt(1, customerId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    customer = new PersonImpl(resultSet.getInt("customer_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("identityNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"));
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
        return customer;
    }

    @Override
    public void removeCustomer(Integer customerId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM customer WHERE customer_id = ?");
                preparedStatement.setInt(1, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
    }

    @Override
    public void updateCustomerTel(Integer customerId, String tel) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE customer SET  tel =?  WHERE customer_id = ?");
                preparedStatement.setString(1, tel);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
    }

    @Override
    public void updateCustomerEmail(Integer customerId, String email) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE customer SET  email =?  WHERE customer_id = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
    }

    @Override
    public void updateCustomerAddress(Integer customerId, String address) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE customer SET  address =?  WHERE customer_id = ?");
                preparedStatement.setString(1, address);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
    }

    @Override
    public List<Person> getAllCustomers() {
        List<Person> customers = new ArrayList<>();
        Person customer = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM customer;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new PersonImpl(resultSet.getInt("customer_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("identityNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"));
                    customers.add(customer);
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
        }
        return customers;
    }

}
