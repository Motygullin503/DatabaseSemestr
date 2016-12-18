package entities;

/**
 * Created by UseR7 on 16.12.2016.
 */
public class Specialization {
    private int spec_id;
    private String name;

    public Specialization() {
    }

    public Specialization(int spec_id, String name) {
        this.spec_id = spec_id;
        this.name = name;
    }

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
