package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Subtopic")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Subtopic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Subtopic")
    private int subtopic_id;
    @Column(name = "Name")
    private String subtopic_name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Course",
            joinColumns = { @JoinColumn(name = "Id_Subtopic")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Course")}
    )
    private List<Course> courses = new ArrayList<Course>();

    public int getSubtopic_id() {
        return subtopic_id;
    }

    public void setSubtopic_id(int subtopic_id) {
        this.subtopic_id = subtopic_id;
    }

    public String getSubtopic_name() {
        return subtopic_name;
    }

    public void setSubtopic_name(String subtopic_name) {
        this.subtopic_name = subtopic_name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}