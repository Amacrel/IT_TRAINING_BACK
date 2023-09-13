package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Course")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Course")
    private int course_id;
    @Column(name="Name")
    private String course_name;
    @Column(name="Created_At")
    private Date created_at;
    @Column(name="Updated_At")
    private Date updated_at;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Subtopic> subtopics = new ArrayList<Subtopic>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Session> sessions = new ArrayList<Session>();
}