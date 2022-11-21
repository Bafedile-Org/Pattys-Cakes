package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.EmployeeDAO;
import za.co.pattyBakery.dao.impl.EmployeeDAOImpl;
import za.co.pattyBakery.model.EmployeeImpl;

/**
 *
 * @author Bridget Bapela
 */
public class EmployeeServImpl implements EmployeeDAO {

    private EmployeeDAOImpl employeeDAOImpl;

    public EmployeeServImpl(EmployeeDAOImpl employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Override
    public void addEmployee(EmployeeImpl employee) {
        if (employee == null) {

        }
        employeeDAOImpl.addEmployee(employee);
    }

    @Override
    public EmployeeImpl getEmployeeById(Integer employeeId) {
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
    public List<EmployeeImpl> getAllEmployees() {
        return employeeDAOImpl.getAllEmployees();
    }

}
