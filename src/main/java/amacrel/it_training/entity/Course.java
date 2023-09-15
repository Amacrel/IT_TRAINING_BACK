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
@Table(name="Course")
//@Data
//@AllArgsConstructor @NoArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Course")
    private int course_id;
    @Column(name="Name")
    private String course_name;
    @Column(name="Created_At")
    private Date created_at;
    @Column(name="Updated_At")
    private Date updated_at;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Subtopic> subtopics = new ArrayList<Subtopic>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Session> sessions = new ArrayList<Session>();


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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

    public List<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}