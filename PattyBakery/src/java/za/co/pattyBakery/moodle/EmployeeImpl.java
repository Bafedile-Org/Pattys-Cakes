package za.co.pattyBakery.moodle;

import za.co.pattyBakery.Employee;

/**
 *
 * @author Bridget Bapela
 */
public class EmployeeImpl extends PersonImpl implements Employee {

    String title;

    public EmployeeImpl(String name, String surname, String idNumber, String address, String tel, String email, String title) {
        super(name, surname, idNumber, address, tel, email);
        this.title = title;
    }

    public EmployeeImpl(Integer personId, String name, String surname, String idNumber, String address, String tel, String email, String title) {
        super(personId, name, surname, idNumber, address, tel, email);
        this.title = title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
