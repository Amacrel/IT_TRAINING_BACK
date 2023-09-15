package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Role")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Role")
    private int role_id;
    @Column(name = "Rights")
    private String rights;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}