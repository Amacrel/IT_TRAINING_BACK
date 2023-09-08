package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Topic")
    private int topic_id;
    @Column(name = "name")
    private String topic_name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Subtopic",
            joinColumns = { @JoinColumn(name = "Id_Subtopic")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Topic")}
    )
    private List<Subtopic> subtopics = new ArrayList<Subtopic>();
}
