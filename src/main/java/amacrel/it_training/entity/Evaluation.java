package amacrel.it_training.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Evaluation")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Evaluation")}
    )
    private List<_User> _users = new ArrayList<_User>();

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public Boolean getHas_requirements() {
        return has_requirements;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public int getGrade() {
        return grade;
    }
    @JsonIgnore
    public List<_User> get_users() {
        return _users;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public void setHas_requirements(Boolean has_requirements) {
        this.has_requirements = has_requirements;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void set_users(List<_User> _users) {
        this._users = _users;
    }
}