package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.Person;
import za.co.pattyBakery.dao.CustomerDAO;
import za.co.pattyBakery.dao.LoginDAO;
import za.co.pattyBakery.dao.impl.CustomerDAOImpl;
import za.co.pattyBakery.dao.impl.LoginDAOImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CustomerServImpl implements CustomerDAO, LoginDAO {
    
    private CustomerDAO customerDAOImpl;
    private LoginDAO loginDAOImpl;
    
    public CustomerServImpl() {
        customerDAOImpl = new CustomerDAOImpl();
        loginDAOImpl = new LoginDAOImpl();
    }
    
    @Override
    public void addCustomer(Person customer) {
        if (customer == null) {
            
        }
        customerDAOImpl.addCustomer(customer);
    }
    
    @Override
    public Person getCustomerById(Integer customerId) {
        if (customerId <= 0) {
            return null;
        }
        return customerDAOImpl.getCustomerById(customerId);
    }
    
    @Override
    public void removeCustomer(Integer customerId) {
        if (customerId <= 0) {
            return;
        }
        customerDAOImpl.removeCustomer(customerId);
    }
    
    @Override
    public void updateCustomerTel(Integer customerId, String tel) {
        if (tel == null || customerId <= 0) {
            return;
        }
        customerDAOImpl.updateCustomerTel(customerId, tel);
    }
    
    @Override
    public void updateCustomerEmail(Integer customerId, String email) {
        if (email == null || customerId <= 0) {
            return;
        }
        customerDAOImpl.updateCustomerEmail(customerId, email);
    }
    
    @Override
    public void updateCustomerAddress(Integer customerId, String address) {
        if (address == null && customerId <= 0) {
            return;
        }
        customerDAOImpl.updateCustomerAddress(customerId, address);
    }
    
    @Override
    public List<Person> getAllCustomers() {
        return customerDAOImpl.getAllCustomers();
    }
    
    @Override
    public Person getCustomerByEmail(String email) {
        return customerDAOImpl.getCustomerByEmail(email);
    }
    
    @Override
    public String getCustomerPassword(Integer customerId, String email) {
        return loginDAOImpl.getCustomerPassword(customerId, email);
    }
    
    @Override
    public void addCustomerLogins(Integer customerId, String email, String password) {
        loginDAOImpl.addCustomerLogins(customerId, email, password);
    }
    
    @Override
    public void removeCustomerLogins(Integer customerId, String email) {
        loginDAOImpl.removeCustomerLogins(customerId, email);
    }
    
}
