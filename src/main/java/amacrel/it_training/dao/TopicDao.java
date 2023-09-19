package amacrel.it_training.dao;

import amacrel.it_training.entity.Topic;
import amacrel.it_training.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Topic createTopic(Topic topic) {
        return this.topicRepository.save(topic);
    }

    public Topic updateTopic(int id, Topic topic) {
        Topic existingTopic = this.getTopicById(id).get();
        if (this.getTopicById(id).isPresent()) {
            if (topic.getSubtopics() != null && !Objects.equals(topic.getSubtopics(), existingTopic.getSubtopics())) {
                existingTopic.setSubtopics(topic.getSubtopics());
            }
            if (!topic.getTopic_name().isEmpty() && !topic.getTopic_name().isBlank() && !Objects.equals(topic.getTopic_name(),
                    existingTopic.getTopic_name())) {
                existingTopic.setTopic_name(topic.getTopic_name());
            }
        }
        return this.topicRepository.save(existingTopic);

    }

    public void deleteTopic(Topic topic) {
        this.topicRepository.delete(topic);
    }
}
