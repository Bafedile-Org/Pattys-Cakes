package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattyBakery.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface CustomerDAO {

    void addCustomer(Person customer);

    Person getCustomerById(Integer customerId);

    void removeCustomer(Integer customerId);

    void updateCustomerTel(Integer customerId, String tel);

    void updateCustomerEmail(Integer customerId, String email);

    void updateCustomerAddress(Integer customerId, String address);

    List<Person> getAllCustomers();
}
