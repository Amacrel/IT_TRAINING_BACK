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
    @Column(name = "createdAt")
    private Date created_at;
    @Column(name = "UpdatedAt")
    private Date updated_at;
    private int grade;
    @Column(name = "hasRequirements")
    private Boolean has_requirements;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Session", referencedColumnName = "Id_Session")
    private Session session;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Evaluation")}
    )
    private List<_User> users = new ArrayList<_User>();
}
