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
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class _User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Users")
    private int _user_id;
    @Column(name = "First_Name")
    private String _user_firstname;
    @Column(name = "Last_Name")
    private String _user_lastname;
    @Column(name = "Email")
    private String _user_email;
    @Column(name = "Birth_Date")
    private Date _user_birthdate;
    @Column(name = "Password")
    private String _user_password;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "_users")
    private List<Session> sessions = new ArrayList<Session>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "_users")
    private List<Evaluation> evaluations;
}