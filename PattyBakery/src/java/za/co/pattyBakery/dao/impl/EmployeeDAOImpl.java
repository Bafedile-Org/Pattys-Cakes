package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.model.EmployeeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection con = null;

    public EmployeeDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public EmployeeDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addEmployee(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {

            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO employee (name, surname,idNum,tel, email, address,title) VALUES(?,?,?,?,?,?,?);");
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
    public Employee getEmployeeById(Integer employeeId) {
        Employee employee = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM employee WHERE emp_id = ?");
                preparedStatement.setInt(1, employeeId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    employee = new EmployeeImpl(resultSet.getInt("emp_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("idNum"),
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
            if (con != null) {

                preparedStatement = con.prepareStatement("DELETE  FROM employee WHERE emp_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE employee SET  tel =?  WHERE emp_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE employee SET  email =?  WHERE emp_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE employee SET  address =?  WHERE emp_id = ?");
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
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM employee;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    employee = getEmployeeById(resultSet.getInt("emp_id"));
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

    @Override
    public void addCustomerLogins(Integer employeeId, String email, String password) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO employee_login VALUES (?,?,?);");
                preparedStatement.setInt(1, employeeId);
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
    public void removeCustomerLogins(Integer employeeId, String email) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE  FROM employee_login WHERE id = ? AND email=?");
                preparedStatement.setInt(1, employeeId);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public String getCustomerPassword(Integer employeeId, String email) {
        String password = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM employee_login WHERE email = ? AND id=?");
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, employeeId);
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

    @Override
    public void updateCustomerPassword(String email, String password) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE employee_login SET password = ? WHERE email = ?");
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM employee WHERE email = ?");
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    employee = new EmployeeImpl(resultSet.getInt("emp_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("idNum"),
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

}
