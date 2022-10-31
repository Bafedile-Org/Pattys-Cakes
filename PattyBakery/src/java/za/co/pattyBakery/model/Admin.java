package za.co.pattyBakery.model;

/**
 *
 * @author Bridget Bapela
 */
public class Admin extends EmployeeImpl {

    public Admin(String name, String surname, String idNumber, String address, String tel, String email, String title) {

        super(name, surname, idNumber, address, tel, email, title);
    }

    public Admin(String name, String surname, String idNumber, String address, String tel, String email, Integer personId, String title) {

        super(personId, name, surname, idNumber, address, tel, email, title);
    }

}
