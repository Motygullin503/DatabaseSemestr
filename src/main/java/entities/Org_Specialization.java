package entities;

/**
 * Created by UseR7 on 17.12.2016.
 */
public class Org_Specialization {

    private int spec_org_id;
    private int org_id;
    private int spec_id;
    private String service_name;

    public Org_Specialization() {
    }

    public Org_Specialization(int spec_org_id, int org_id, int spec_id, String service_name) {
        this.spec_org_id = spec_org_id;
        this.org_id = org_id;
        this.spec_id = spec_id;
        this.service_name = service_name;
    }

    public int getSpec_org_id() {
        return spec_org_id;
    }

    public void setSpec_org_id(int spec_org_id) {
        this.spec_org_id = spec_org_id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
