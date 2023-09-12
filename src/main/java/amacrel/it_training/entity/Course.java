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
    @Column(name="name")
    private String course_name;
    @Column(name="createdAt")
    private Date created_at;
    @Column(name="updatedAt")
    private Date updated_at;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Subtopic",
            joinColumns = { @JoinColumn(name = "Id_Subtopic")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Course")}
    )
    private Subtopic subtopic;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Session",
            joinColumns = { @JoinColumn(name = "Id_Session")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Course")}
    )
    private List<Session> sessions = new ArrayList<Session>();
}
