package amacrel.it_training.controller;

import amacrel.it_training.dao.SubtopicDao;
import amacrel.it_training.entity.Subtopic;
import amacrel.it_training.entity.Topic;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subtopics")
@Data
public class SubtopicRestController {
    @Autowired
    private SubtopicDao subtopicDao;

    @GetMapping("/")
    public List<Subtopic> getSubtopics() {
        return subtopicDao.getSubtopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subtopic> getSubtopicById(@PathVariable int id) {
        Optional<Subtopic> subtopic = subtopicDao.getSubtopicById(id);
        return subtopic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Subtopic createSubtopic(@RequestBody Subtopic subtopic) {
        return subtopicDao.createSubtopic(subtopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subtopic> updateSubtopic(@PathVariable int id, @RequestBody Subtopic updatedSubtopic) {
        Optional<Subtopic> existingSubtopic = subtopicDao.getSubtopicById(id);
        return existingSubtopic.map(subtopic -> ResponseEntity.ok(subtopicDao.updateSubtopic(id, updatedSubtopic))). orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubtopic(@PathVariable int id) {
        Optional<Subtopic> subtopic = subtopicDao.getSubtopicById(id);

        if (subtopic.isPresent()) {
            subtopicDao.deleteSubtopic(subtopic.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
