package za.co.pattyBakery.dao;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoginDAO extends Close {

    void addCustomerLogins(Integer customerId, String email, String password);

    void removeCustomerLogins(Integer customerId, String email);

    public String getCustomerPassword(Integer customerId, String email);

    public void updateCustomerPassword(String email, String password);

}
