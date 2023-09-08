package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class _User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Users")
    private int _user_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Role")
    private Role _user_role;
    @Column(name = "firstname")
    private int _user_firstname;
    @Column(name = "lastname")
    private int _user_lastname;
    @Column(name = "email")
    private int _user_email;
    @Column(name = "birthdate")
    private int _user_birthdate;
    @Column(name = "password")
    private int _user_password;
    @Column(name = "status")
    private int _user_status;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "_users")
    private List<Session> sessions = new ArrayList<Session>();
}
