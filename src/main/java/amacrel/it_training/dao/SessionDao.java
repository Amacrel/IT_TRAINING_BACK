package amacrel.it_training.dao;

import amacrel.it_training.entity.Session;
import amacrel.it_training.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SessionDao {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getSessions() {
        return this.sessionRepository.findAll();
    }

    public Optional<Session> getSessionByid(int id) {
        return this.sessionRepository.findById(id);
    }

    public void createSession(Session session) {
        this.sessionRepository.save(session);
    }

    public void updateSession(Session session) {
        // TO-DO Check Attributes
        this.sessionRepository.save(session);
    }

    public void deleteSession(Session session) {
        this.sessionRepository.delete(session);
    }
}
