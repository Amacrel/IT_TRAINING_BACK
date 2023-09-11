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

    public String createSubtopic(Subtopic subtopic) {
        try {
            if (!subtopic.getSubtopic_name().equals("")) {
                this.subtopicRepository.save(subtopic);
                return "The subtopic " + subtopic + " has been created";
            } else {
                return "The Subtopic could not be created";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "The Subtopic could not be created";
        }
    }

    public Subtopic updateSubtopic(Subtopic subtopic) {
        // TO-DO Check Attributes
        return this.subtopicRepository.save(subtopic);
    }

    public String deleteSubtopic(Subtopic subtopic) {
        int id = subtopic.getSubtopic_id();
        try {
            if (id != 0) {
                this.subtopicRepository.delete(subtopic);
                return "The Subtopic with id: " + id + " has been deleted successfully";
            } else {
                return "The Subtopic could not be deleted because the id is not valid";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "The subtopic could not be deleted";
        }
    }
}
