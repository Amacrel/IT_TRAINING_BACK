package amacrel.it_training.controller;

import amacrel.it_training.dao.SessionDao;
import amacrel.it_training.entity.Session;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessions")
@Data
public class SessionRestController {

    @Autowired
    private SessionDao sessionDao;


    @GetMapping("/")
    public List<Session> getSessions() {
        return this.sessionDao.getSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable int id) {
        Optional<Session> session = sessionDao.getSessionByid(id);
        return session.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Session createSession(@RequestBody Session session) {
        return sessionDao.createSession(session);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable int id,@RequestBody Session updatedSession) {
        Optional<Session> existingSession = sessionDao.getSessionByid(id);
        return existingSession.map(session -> ResponseEntity.ok(sessionDao.updateSession(id, updatedSession))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable int id) {
        Optional<Session> session = sessionDao.getSessionByid(id);

        if(session.isPresent()) {
            sessionDao.deleteSession(session.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
