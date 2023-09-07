package amacrel.it_training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="course")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy.IDENTITY)
    private int course_id;
    private String course_name;

}
