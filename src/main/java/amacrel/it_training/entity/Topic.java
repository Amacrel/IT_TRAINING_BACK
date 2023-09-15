package amacrel.it_training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Topic")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Topic")
    private int topic_id;
    @Column(name = "Name")
    private String topic_name;
    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Subtopic> subtopics;

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public List<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }
}