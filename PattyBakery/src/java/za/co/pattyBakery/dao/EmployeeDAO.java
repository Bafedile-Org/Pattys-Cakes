package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.Employee;
import za.co.pattyBakery.model.EmployeeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface EmployeeDAO extends LoginDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer employeeId);

    Employee getEmployeeByEmail(String email);

    void removeEmployee(Integer employeeId);

    void updateEmployeeTel(Integer employeeId, String tel);

    void updateEmployeeEmail(Integer employeeId, String email);

    void updateEmployeeAddress(Integer employeeId, String address);

    List<Employee> getAllEmployees();
}
