package amacrel.it_training.controller;

import amacrel.it_training.dao.SubtopicDao;
import amacrel.it_training.entity.Subtopic;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/subtopics")
public class SubtopicRestController {
    private SubtopicDao subtopicDao;

    public SubtopicRestController(SubtopicDao subtopicDao) {
        this.subtopicDao = subtopicDao;
    }

    @GetMapping("/")
    public List<Subtopic> getSubtopics() {
        return this.subtopicDao.getSubtopics();
    }

    @GetMapping("/{id}")
    public Optional<Subtopic> getSubtopicById(@PathVariable int id) {
        return this.subtopicDao.getSubtopicById(id);
    }

    @PostMapping("/create")
    public Subtopic createSubtopic(@RequestBody Subtopic subtopic) {
        return this.subtopicDao.createSubtopic(subtopic);
    }

    @PutMapping("/update")
    public Subtopic updateSubtopic(@RequestBody Subtopic subtopic) {
        return this.subtopicDao.updateSubtopic(subtopic);
    }

    @DeleteMapping("/delete")
    public String deleteSubtopic(@RequestBody Subtopic subtopic) {
        return this.subtopicDao.deleteSubtopic(subtopic);
    }
}
