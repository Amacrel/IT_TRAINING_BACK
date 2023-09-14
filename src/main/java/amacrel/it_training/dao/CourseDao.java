package amacrel.it_training.dao;

import amacrel.it_training.entity.Course;
import amacrel.it_training.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Course createCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course updateCourse(int id, Course course) {
        Course existingCourse = this.getCourseById(id).get();
        if(this.getCourseById(id).isPresent()) {
            if(course.getSubtopics() != null && !Objects.equals(course.getSubtopics(), existingCourse.getSubtopics())) {
                existingCourse.setSubtopics(course.getSubtopics());
            }
            if(course.getSessions() != null && !Objects.equals(course.getSessions(), existingCourse.getSessions())) {
                existingCourse.setSessions(course.getSessions());
            }
            if(!course.getCourse_name().isEmpty() && !course.getCourse_name().isBlank() && !Objects.equals(course.getCourse_name(), existingCourse.getCourse_name())) {
                existingCourse.setCourse_name(course.getCourse_name());
            }
            if(course.getCreated_at() != null && !Objects.equals(course.getCreated_at(),
                    existingCourse.getCreated_at())) {
                existingCourse.setCreated_at(course.getCreated_at());
            }
            if(course.getUpdated_at() != null && !Objects.equals(course.getUpdated_at(),
                    existingCourse.getUpdated_at())) {
                existingCourse.setUpdated_at(course.getUpdated_at());
            }
        }
        return this.courseRepository.save(existingCourse);
    }

    public void deleteCourse(Course course) {
        this.courseRepository.delete(course);
    }
}
