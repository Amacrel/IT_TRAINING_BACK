package amacrel.it_training.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Session")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Session")
    private int session_id;
    @Column(name = "Name")
    private String session_name;
    @Column(name = "Price")
    private double session_price;
    @Column(name = "Location")
    private String session_location;
    @Column(name = "Slot")
    private int session_slot;
    @Column(name = "Created_At")
    private Date created_at;
    @Column(name = "Updated_At")
    private Date updated_at;
    @Column(name = "Type")
    private String session_type;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Evaluation> evaluations;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Session")}
    )
    private List<_User> _users = new ArrayList<_User>();
}