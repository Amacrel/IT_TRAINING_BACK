package amacrel.it_training.dao;

import amacrel.it_training.entity.Topic;
import amacrel.it_training.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TopicDao {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics() {
        return this.topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(int id) {
        return this.topicRepository.findById(id);
    }

    public void createTopic(Topic topic) {
        this.topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        // TO-DO Check Attributes
        this.topicRepository.save(topic);
    }

    public void deleteTopic(Topic topic) {
        this.topicRepository.delete(topic);
    }
}
