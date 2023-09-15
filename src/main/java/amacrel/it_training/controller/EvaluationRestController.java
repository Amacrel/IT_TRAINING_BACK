package amacrel.it_training.controller;

import amacrel.it_training.dao.EvaluationDao;
import amacrel.it_training.entity.Evaluation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/evaluations")
@Data
public class EvaluationRestController {

    @Autowired
    private EvaluationDao evaluationDao;

    @GetMapping("/")
    public List<Evaluation> getEvaluations() {
        return evaluationDao.getEvaluations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable int id) {
        Optional<Evaluation> evaluation = evaluationDao.getEvaluationById(id);
        return evaluation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationDao.createEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable int id,@RequestBody Evaluation updatedEvaluation) {
        Optional<Evaluation> existingEvaluation = evaluationDao.getEvaluationById(id);
        return existingEvaluation.map(evaluation -> ResponseEntity.ok(evaluationDao.updateEvaluation(id,
                updatedEvaluation))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvaluation(@PathVariable int id) {
        Optional<Evaluation> evaluation = evaluationDao.getEvaluationById(id);

        if (evaluation.isPresent()) {
            evaluationDao.deleteEvaluation(evaluation.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
