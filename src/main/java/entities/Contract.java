package entities;

/**
 * Created by UseR7 on 16.12.2016.
 */
public class Contract {
    private int id;
    private int customer_id;
    private int spec_org_id;

    public Contract() {
    }

    public Contract(int id, int customer_id, int spec_org_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.spec_org_id = spec_org_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getSpec_org_id() {
        return spec_org_id;
    }

    public void setSpec_org_id(int spec_org_id) {
        this.spec_org_id = spec_org_id;
    }
}