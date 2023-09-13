package amacrel.it_training.controller;

import amacrel.it_training.dao.CourseDao;
import amacrel.it_training.entity.Course;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/courses")
@Data
public class CourseRestController {

    private CourseDao courseDao;

    public CourseRestController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/all")
    public List<Course> getCourses() {
        return this.courseDao.getCourses();
    }

    @GetMapping("/{id}/")
    public Optional<Course> getCoursebyId(@PathVariable int id) {
        return this.courseDao.getCourseById(id);
    }

    @PostMapping("/create")
    public void createCourse(@RequestBody Course course) {
        this.courseDao.createCourse(course);
    }

    @PutMapping("/update")
    public void updateCourse(@RequestBody Course course) {
        this.courseDao.updateCourse(course);
    }

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestBody Course course) {
        this.courseDao.deleteCourse(course);
    }
}
