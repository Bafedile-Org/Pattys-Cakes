package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.Employee;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface EmployeeDAO extends Close {

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer employeeId);

    public void removeEmployee(String employeeId) ;

    void updateEmployeeTel(Integer employeeId, String tel);

    void updateEmployeeEmail(Integer employeeId, String email);

    void updateEmployeeAddress(Integer employeeId, String address);

    List<Employee> getAllEmployees();
}
