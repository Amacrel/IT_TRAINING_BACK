package amacrel.it_training.controller;

import amacrel.it_training.dao.TopicDao;
import amacrel.it_training.entity.Topic;
import amacrel.it_training.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicRestController {
    @Autowired
    private TopicDao topicDao;

    @GetMapping("/")
    public List<Topic> getTopics() {
        return topicDao.getTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable int id) {
        Optional<Topic> topic = topicDao.getTopicById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Topic createTopic(@RequestBody Topic topic) {
        return topicDao.createTopic(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable int id, @RequestBody Topic updatedTopic) {
        Optional<Topic> existingTopic = topicDao.getTopicById(id);
        return existingTopic.map(topic -> ResponseEntity.ok(topicDao.updateTopic(id, updatedTopic)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable int id) {
        Optional<Topic> topic = topicDao.getTopicById(id);

        if (topic.isPresent()) {
            topicDao.deleteTopic(topic.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
