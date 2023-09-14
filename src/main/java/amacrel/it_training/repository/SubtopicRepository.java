package amacrel.it_training.repository;

import amacrel.it_training.entity.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer> {
}
