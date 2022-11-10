package za.co.pattyBakery.model;

/**
 *
 * @author Bridget Bapela
 */
public class CustomerImpl extends PersonImpl {

    public CustomerImpl(String name, String surname, String idNumber, String address, String tel, String email) {
        super(name, surname, idNumber, address, tel, email);
    }

    public CustomerImpl(String name, String surname, String idNumber, String address, String tel, String email, Integer personId) {
        super(personId, name, surname, idNumber, address, tel, email);
    }

}
