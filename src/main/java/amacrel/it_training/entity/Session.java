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
@Table(name = "Session")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
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
    @OneToMany(fetch = FetchType.EAGER)
    private List<Evaluation> evaluations;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Users",
            joinColumns = { @JoinColumn(name = "Id_Users")},
            inverseJoinColumns = { @JoinColumn(name = "Id_Session")}
    )
    private List<_User> _users = new ArrayList<_User>();

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @JsonIgnore
    public List<_User> get_users() {
        return _users;
    }

    public void set_users(List<_User> _users) {
        this._users = _users;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public double getSession_price() {
        return session_price;
    }

    public void setSession_price(double session_price) {
        this.session_price = session_price;
    }

    public String getSession_location() {
        return session_location;
    }

    public void setSession_location(String session_location) {
        this.session_location = session_location;
    }

    public int getSession_slot() {
        return session_slot;
    }

    public void setSession_slot(int session_slot) {
        this.session_slot = session_slot;
    }

    public String getSession_type() {
        return session_type;
    }

    public void setSession_type(String session_type) {
        this.session_type = session_type;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}