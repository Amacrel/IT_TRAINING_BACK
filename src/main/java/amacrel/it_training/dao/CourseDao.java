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

    public Optional<Course> getCourse(int id) {
        return this.courseRepository.findById(id);
    }

    public String deleteCourseById(int id) {
        if (id != 0) {
            this.courseRepository.deleteById(id);
            return "The course has been deleted successfully";
        } else {
            return "The id provided is invalid";
        }
    }

    public void deleteCourse(Course course) {
        if (course.getId() != 0) {
            this.courseRepository.delete(course);
        }
    }
}
