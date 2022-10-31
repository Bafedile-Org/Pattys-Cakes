package za.co.pattyBakery;

/**
 *
 * @author Bridget Bapela
 */
public interface Person {

    public void setName(String name);

    public String getName();

    public void setSurname(String surname);

    public String getSurname();

    public String getIdNumber();

    public void setDeliveryAddress(String address);

    public String getDeliveryAddress();

    public void setTelephoneNumber(String tel);

    public String getTelephoneNumber();

    public void setEmail(String email);

    public String getEmail();

    public void setPersonId(Integer id);

    public Integer getPersonId();

}
