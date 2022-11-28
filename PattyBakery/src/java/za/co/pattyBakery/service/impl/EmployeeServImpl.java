package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.impl.EmployeeDAOImpl;
import za.co.pattyBakery.model.EmployeeImpl;
import za.co.pattyBakery.Employee;

/**
 *
 * @author Bridget Bapela
 */
public class EmployeeServImpl implements EmployeeDAO {
    
    private EmployeeDAOImpl employeeDAOImpl;
    
    public EmployeeServImpl() {
        this.employeeDAOImpl = new EmployeeDAOImpl();
    }
    
    @Override
    public void addEmployee(Employee employee) {
        if (employee == null) {
            
        }
        employeeDAOImpl.addEmployee(employee);
    }
    
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        if (employeeId <= 0) {
            return null;
        }
        return employeeDAOImpl.getEmployeeById(employeeId);
    }
    
    @Override
    public void removeEmployee(Integer employeeId) {
        if (employeeId <= 0) {
            return;
        }
        employeeDAOImpl.removeEmployee(employeeId);
    }
    
    @Override
    public void updateEmployeeTel(Integer employeeId, String tel) {
        if (tel == null || employeeId <= 0) {
            return;
        }
        employeeDAOImpl.updateEmployeeTel(employeeId, tel);
    }
    
    @Override
    public void updateEmployeeEmail(Integer employeeId, String email) {
        if (email == null || employeeId <= 0) {
            return;
        }
        employeeDAOImpl.updateEmployeeEmail(employeeId, email);
    }
    
    @Override
    public void updateEmployeeAddress(Integer employeeId, String address) {
        if (address == null && employeeId <= 0) {
            return;
        }
        employeeDAOImpl.updateEmployeeAddress(employeeId, address);
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAOImpl.getAllEmployees();
    }
    
    @Override
    public void addCustomerLogins(Integer customerId, String email, String password) {
        employeeDAOImpl.addCustomerLogins(customerId, email, password);
    }
    
    @Override
    public void removeCustomerLogins(Integer customerId, String email) {
        employeeDAOImpl.removeCustomerLogins(customerId, email);
    }
    
    @Override
    public String getCustomerPassword(Integer customerId, String email) {
        return employeeDAOImpl.getCustomerPassword(customerId, email);
    }
    
    @Override
    public void updateCustomerPassword(String email, String password) {
        employeeDAOImpl.updateCustomerPassword(email, password);
    }
    
    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeDAOImpl.getEmployeeByEmail(email);
    }
    
}
