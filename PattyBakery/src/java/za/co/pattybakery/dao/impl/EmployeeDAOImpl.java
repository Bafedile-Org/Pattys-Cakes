package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattybakery.dao.EmployeeDAO;
import za.co.pattybakery.model.EmployeeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection conn = null;

    @Override
    public void addEmployee(EmployeeImpl employee) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO employee (name, surname,identityNum,tel, email, address,title) VALUES(?,?,?,?,?,?,?);");
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getIdNumber());
                preparedStatement.setString(4, employee.getTelephoneNumber());
                preparedStatement.setString(5, employee.getEmail());
                preparedStatement.setString(6, employee.getDeliveryAddress());
                preparedStatement.setString(7, employee.getTitle());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public EmployeeImpl getEmployeeById(Integer employeeId) {
        EmployeeImpl employee = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM employee WHERE emp_id = ?");
                preparedStatement.setInt(1, employeeId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    employee = new EmployeeImpl(resultSet.getInt("cust_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("identityNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("title"));
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return employee;
    }

    @Override
    public void removeEmployee(Integer employeeId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM employee WHERE emp_id = ?");
                preparedStatement.setInt(1, employeeId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateEmployeeTel(Integer employeeId, String tel) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE employee SET  tel =?  WHERE emp_id = ?");
                preparedStatement.setString(1, tel);
                preparedStatement.setInt(2, employeeId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateEmployeeEmail(Integer employeeId, String email) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE employee SET  email =?  WHERE emp_id = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, employeeId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public void updateEmployeeAddress(Integer employeeId, String address) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE employee SET  address =?  WHERE emp_id = ?");
                preparedStatement.setString(1, address);
                preparedStatement.setInt(2, employeeId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public List<EmployeeImpl> getAllEmployees() {
        List<EmployeeImpl> employees = new ArrayList<>();
        EmployeeImpl employee = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM customer;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    employee = new EmployeeImpl(resultSet.getInt("cust_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("identityNum"),
                            resultSet.getString("tel"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("title"));
                    employees.add(employee);
                }
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return employees;
    }

}
