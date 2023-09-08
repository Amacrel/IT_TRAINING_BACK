package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(name = "name")
    private String category_name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Topic",
            joinColumns = { @JoinColumn(name = "Id_Topic")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Category")}
    )
    private List<Topic> topics = new ArrayList<Topic>();

}
