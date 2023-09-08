package amacrel.it_training.dao;

import amacrel.it_training.entity.Course;
import amacrel.it_training.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseDao {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return this.courseRepository.findById(id);
    }

    public void createCourse(Course course) {
        this.courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        // TO-DO Check Attributes
        this.courseRepository.save(course);
    }

    public void deleteCourse(Course course) {
        this.courseRepository.delete(course);
    }
}
