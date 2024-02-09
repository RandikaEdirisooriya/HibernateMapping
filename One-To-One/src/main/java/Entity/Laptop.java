package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    private String id;
    private String model;

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Laptop(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public Laptop() {
    }
}
