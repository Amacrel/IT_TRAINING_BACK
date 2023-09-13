package amacrel.it_training.controller;

import amacrel.it_training.dao.SessionDao;
import amacrel.it_training.entity.Session;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessions")
@Data
public class SessionRestController {

    private SessionDao sessionDao;

    public SessionRestController(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @GetMapping("/all")
    public List<Session> getSessions() {
        return this.sessionDao.getSessions();
    }

    @GetMapping("/{id}/")
    public Optional<Session> getSessionById(@PathVariable int id) {
        return this.sessionDao.getSessionByid(id);
    }

    @PostMapping("/create")
    public void createSession(@RequestBody Session session) {
        this.sessionDao.createSession(session);
    }

    @PutMapping("/update")
    public void updateSession(@RequestBody Session session) {
        this.sessionDao.updateSession(session);
    }

    @DeleteMapping("/delete")
    public void deleteSession(@RequestBody Session session) {
        this.sessionDao.deleteSession(session);
    }

}
