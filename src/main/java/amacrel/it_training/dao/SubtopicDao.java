package amacrel.it_training.dao;

import amacrel.it_training.entity.Subtopic;
import amacrel.it_training.repository.SubtopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Subtopic createSubtopic(Subtopic subtopic) {
        return this.subtopicRepository.save(subtopic);
    }

    public Subtopic updateSubtopic(int id, Subtopic subtopic) {
        Subtopic existingSubtopic = this.getSubtopicById(id).get();
        if (this.getSubtopicById(id).isPresent()) {
            if (subtopic.getCourses() != null && !Objects.equals(subtopic.getCourses(), existingSubtopic.getCourses())) {
                existingSubtopic.setCourses(subtopic.getCourses());
            }
            if (subtopic.getSubtopic_name().isEmpty() && subtopic.getSubtopic_name().isBlank() && !Objects.equals(subtopic.getSubtopic_name(), existingSubtopic.getSubtopic_name())) {
                existingSubtopic.setSubtopic_name(subtopic.getSubtopic_name());
            }
        }
        return this.subtopicRepository.save(existingSubtopic);
    }

    public void deleteSubtopic(Subtopic subtopic) {
        this.subtopicRepository.delete(subtopic);
    }
}
