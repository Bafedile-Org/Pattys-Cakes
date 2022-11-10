package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.model.EmployeeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface EmployeeDAO extends Close {

    void addEmployee(EmployeeImpl employee);

    EmployeeImpl getEmployeeById(Integer employeeId);

    void removeEmployee(Integer employeeId);

    void updateEmployeeTel(Integer employeeId, String tel);

    void updateEmployeeEmail(Integer employeeId, String email);

    void updateEmployeeAddress(Integer employeeId, String address);

    List<EmployeeImpl> getAllEmployees();
}
