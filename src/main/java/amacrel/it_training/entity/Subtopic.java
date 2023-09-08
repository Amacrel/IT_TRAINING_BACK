package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    @Column(name = "name")
    private String subtopic_name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Course")
    private Course course;
}
