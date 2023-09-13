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
@Table(name = "Evaluation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Evaluation")
    private int evaluation_id;
    @Column(name = "Created_At")
    private Date created_at;
    @Column(name = "Updated_At")
    private Date updated_at;
    private int grade;
    @Column(name = "Has_Requirements")
    private Boolean has_requirements;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Evaluation")}
    )
    private List<_User> _users = new ArrayList<_User>();
}