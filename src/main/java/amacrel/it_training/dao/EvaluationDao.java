package amacrel.it_training.dao;

import amacrel.it_training.entity.Evaluation;
import amacrel.it_training.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EvaluationDao {
    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getEvaluations() {
        return this.evaluationRepository.findAll();
    }

    public Optional<Evaluation> getEvaluationById(int id) {
        return this.evaluationRepository.findById(id);
    }

    public void createEvaluation(Evaluation evaluation) {
        this.evaluationRepository.save(evaluation);
    }

    public void updateEvaluation(Evaluation evaluation) {
        // TO-DO Check Attributes
        this.evaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(Evaluation evaluation){
        this.evaluationRepository.delete(evaluation);
    }
}
