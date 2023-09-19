package amacrel.it_training.controller;

import amacrel.it_training.dao.CourseDao;
import amacrel.it_training.entity.Course;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/courses")
@Data
public class CourseRestController {
    @Autowired
    private CourseDao courseDao;

    @GetMapping("/")
    public List<Course> getCourses() {
        return this.courseDao.getCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCoursebyId(@PathVariable int id) {
        Optional<Course> course = courseDao.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course course) {
        return courseDao.createCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
        Optional<Course> existingCourse = courseDao.getCourseById(id);
        return existingCourse.map(course -> ResponseEntity.ok(courseDao.updateCourse(id, updatedCourse))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        Optional<Course> course = courseDao.getCourseById(id);
        if (course.isPresent()) {
            courseDao.deleteCourse(course.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
