package entities;

/**
 * Created by UseR7 on 16.12.2016.
 */
public class Organization {

    private int org_id;
    private String name;
    private String type_of_ownership;
    private String work_time;
    private String work_days;
    private String address;
    private String phone;

    public Organization() {
    }

    public Organization(int org_id, String name, String type_of_ownership, String work_time, String work_days, String address, String phone) {
        this.org_id = org_id;
        this.name = name;
        this.type_of_ownership = type_of_ownership;
        this.work_time = work_time;
        this.work_days = work_days;
        this.address = address;
        this.phone = phone;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_of_ownership() {
        return type_of_ownership;
    }

    public void setType_of_ownership(String type_of_ownership) {
        this.type_of_ownership = type_of_ownership;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getWork_days() {
        return work_days;
    }

    public void setWork_days(String work_days) {
        this.work_days = work_days;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
