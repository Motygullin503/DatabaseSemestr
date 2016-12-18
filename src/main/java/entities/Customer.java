package entities;

/**
 * Created by UseR7 on 16.12.2016.
 */
public class Customer {
    private int customer_id;
    private String name;
    private String city;
    private String eaddress;
    private String phone_number;
    private String password;

    public Customer() {
    }

    public Customer(String name, String city, String eaddress, String phone_number, String password) {

        this.name = name;
        this.city = city;
        this.eaddress = eaddress;
        this.phone_number = phone_number;
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
