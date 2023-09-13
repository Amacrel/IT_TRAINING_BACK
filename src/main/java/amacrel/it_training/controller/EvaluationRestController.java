package amacrel.it_training.controller;

import amacrel.it_training.dao.EvaluationDao;
import amacrel.it_training.entity.Evaluation;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/evaluations")
@Data
public class EvaluationRestController {

    private EvaluationDao evaluationDao;

    public EvaluationRestController(EvaluationDao evaluationDao) {
        this.evaluationDao = evaluationDao;
    }

    @GetMapping("/all")
    public List<Evaluation> getEvaluations() {
        return this.evaluationDao.getEvaluations();
    }

    @GetMapping("/{id}/")
    public Optional<Evaluation> getEvaluationById(@PathVariable int id) {
        return this.evaluationDao.getEvaluationById(id);
    }

    @PostMapping("/create")
    public void createEvaluation(@RequestBody Evaluation evaluation) {
        this.evaluationDao.createEvaluation(evaluation);
    }

    @PutMapping("/update")
    public void updateEvaluation(@RequestBody Evaluation evaluation) {
        this.evaluationDao.updateEvaluation(evaluation);
    }

    @DeleteMapping("/delete")
    public void deleteEvaluation(@RequestBody Evaluation evaluation) {
        this.evaluationDao.deleteEvaluation(evaluation);
    }
}
