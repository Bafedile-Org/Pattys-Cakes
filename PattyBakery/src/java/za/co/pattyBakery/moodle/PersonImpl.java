package za.co.pattyBakery.moodle;

import za.co.pattyBakery.Person;

/**
 *
 * @author Bridget Bapela
 */
public class PersonImpl implements Person {

    String name, surname, idNumber, address, tel, email;
    Integer personId;

    public PersonImpl(String name, String surname, String idNumber, String address, String tel, String email) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.address = address;
        this.tel = tel;
        this.email = email;
    }

    public PersonImpl(Integer personId, String name, String surname, String idNumber, String address, String tel, String email) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.personId = personId;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public void setDeliveryAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDeliveryAddress() {
        return address;
    }

    @Override
    public void setTelephoneNumber(String tel) {
        this.tel = tel;
    }

    @Override
    public String getTelephoneNumber() {
        return tel;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setPersonId(Integer id) {
        this.personId = id;
    }

    @Override
    public Integer getPersonId() {
        return personId;
    }
}
