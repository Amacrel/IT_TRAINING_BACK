package amacrel.it_training.controller;

import amacrel.it_training.dao.SubtopicDao;
import amacrel.it_training.entity.Subtopic;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subtopics")
@Data
public class SubtopicRestController {

    private SubtopicDao subtopicDao;

    public SubtopicRestController(SubtopicDao subtopicDao) {
        this.subtopicDao = subtopicDao;
    }

    @GetMapping("/all")
    public List<Subtopic> getSubtopics() {
        return this.subtopicDao.getSubtopics();
    }

    @GetMapping("/{id}/")
    public Optional<Subtopic> getSubtopicById(@PathVariable int id) {
        return this.subtopicDao.getSubtopicById(id);
    }

    @PostMapping("/create")
    public void createSubtopic(@RequestBody Subtopic subtopic) {
        this.subtopicDao.createSubtopic(subtopic);
    }

    @PutMapping("/update")
    public void updateSubtopic(@RequestBody Subtopic subtopic) {
        this.subtopicDao.updateSubtopic(subtopic);
    }


    @DeleteMapping("/delete")
    public void deleteSubtopic(@RequestBody Subtopic subtopic) {
        this.subtopicDao.deleteSubtopic(subtopic);
    }


}
