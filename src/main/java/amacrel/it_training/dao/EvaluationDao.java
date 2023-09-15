package amacrel.it_training.dao;

import amacrel.it_training.entity.Evaluation;
import amacrel.it_training.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Evaluation createEvaluation(Evaluation evaluation) {
        return this.evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(int id, Evaluation evaluation) {
        Evaluation existingEvaluation = this.getEvaluationById(id).get();
        if (this.getEvaluationById(id).isPresent()) {
            if(evaluation.get_users() != null && !Objects.equals(evaluation.get_users(),
                    existingEvaluation.get_users())) {
                existingEvaluation.set_users(evaluation.get_users());
            }
            if(evaluation.getGrade() != 0 && !Objects.equals(evaluation.getGrade(),
                    existingEvaluation.getGrade())) {
                existingEvaluation.setGrade(evaluation.getGrade());
            }
            if (evaluation.getCreated_at() != null && !Objects.equals(evaluation.getCreated_at(),
                    existingEvaluation.getCreated_at())) {
                existingEvaluation.setCreated_at(evaluation.getCreated_at());
            }
            if (evaluation.getUpdated_at() != null && !Objects.equals(evaluation.getUpdated_at(),
                    existingEvaluation.getUpdated_at())) {
                existingEvaluation.setUpdated_at(evaluation.getUpdated_at());
            }
            if (evaluation.getHas_requirements() != null && !Objects.equals(evaluation.getHas_requirements(),
                    existingEvaluation.getHas_requirements())) {
                existingEvaluation.setHas_requirements(evaluation.getHas_requirements());
            }
        }
        return this.evaluationRepository.save(existingEvaluation);
    }

    public void deleteEvaluation(Evaluation evaluation){
        this.evaluationRepository.delete(evaluation);
    }
}
