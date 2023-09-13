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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}