package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Session")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Session")
    private int session_id;
    @Column(name = "name")
    private String session_name;
    @Column(name = "price")
    private String session_price;
    @Column(name = "location")
    private String session_location;
    @Column(name = "slot")
    private String session_slot;
    @Column(name = "createdAt")
    private String created_at;
    @Column(name = "updatedAt")
    private String updated_at;
    @Column(name = "type")
    private String session_type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Course",
            joinColumns = { @JoinColumn(name = "Id_Course")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Session")}
    )
    private Course course;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Evaluation",
            joinColumns = { @JoinColumn(name = "Id_Evalutation")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Session")}
    )
    private List<Evaluation> evaluations = new ArrayList<Evaluation>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Session")}
    )
    private List<_User> _users = new ArrayList<_User>();
}
