package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.model.EmployeeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface EmployeeDAO {

    void addEmployee(EmployeeImpl customer);

    EmployeeImpl getEmployeeById(Integer employeeId);

    void removeEmployee(Integer employeeId);

    void updateEmployeeTel(Integer employeeId, String tel);

    void updateEmployeeEmail(Integer employeeId, String email);

    void updateEmployeeAddress(Integer employeeId, String address);

    List<EmployeeImpl> getAllEmployees();
}
