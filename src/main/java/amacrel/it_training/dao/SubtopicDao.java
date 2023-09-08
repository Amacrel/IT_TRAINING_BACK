package amacrel.it_training.dao;

import amacrel.it_training.entity.Subtopic;
import amacrel.it_training.repository.SubtopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubtopicDao {
    @Autowired
    private SubtopicRepository subtopicRepository;

    public List<Subtopic> getSubtopics() {
        return this.subtopicRepository.findAll();
    }

    public Optional<Subtopic> getSubtopicById(int id) {
        return this.subtopicRepository.findById(id);
    }

    public void createSubtopic(Subtopic subtopic) {
        this.subtopicRepository.save(subtopic);
    }

    public void updateSubtocpic(Subtopic subtopic) {
        // TO-DO Check Attributes
        this.subtopicRepository.save(subtopic);
    }

    public void deleteSubtopic(Subtopic subtopic) {
        this.subtopicRepository.delete(subtopic);
    }
}
