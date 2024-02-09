package Entity;

import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    private String id;
    private String model;
    @ManyToOne
    private Student student;

    public Laptop() {
    }

    public Laptop(String id, String model, Student student) {
        this.id = id;
        this.model = model;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", student=" + student +
                '}';
    }
}
