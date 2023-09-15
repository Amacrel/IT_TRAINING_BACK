package amacrel.it_training.dao;

import amacrel.it_training.entity.Session;
import amacrel.it_training.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Session createSession(Session session) {
        return this.sessionRepository.save(session);
    }

    public Session updateSession(int id, Session session) {
        Session existingSession = this.getSessionByid(id).get();
        if (this.getSessionByid(id).isPresent()) {
            if(session.getEvaluations() !=null && !Objects.equals(session.getEvaluations(),
                    existingSession.getEvaluations())) {
                existingSession.setEvaluations(session.getEvaluations());
            }
            if(session.get_users() !=null && !Objects.equals(session.get_users(), existingSession.get_users())) {
                existingSession.set_users(session.get_users());
            }
            if(!session.getSession_name().isEmpty() && !session.getSession_name().isBlank() && !Objects.equals(session.getSession_name(), existingSession.getSession_name())) {
                existingSession.setSession_name(session.getSession_name());
            }
            if(session.getSession_price() != 0 && !Objects.equals(session.getSession_price(),
                    existingSession.getSession_price())) {
                existingSession.setSession_price(session.getSession_price());
            }
            if(!session.getSession_location().isBlank() && !session.getSession_location().isEmpty() && !Objects.equals(session.getSession_location(), existingSession.getSession_location())) {
                existingSession.setSession_location(session.getSession_location());
            }
            if(session.getSession_slot() != 0 && !Objects.equals(session.getSession_slot(),
                    existingSession.getSession_slot())) {
                existingSession.setSession_slot(session.getSession_slot());
            }
            if(session.getCreated_at() != null && !Objects.equals(session.getCreated_at(),
                    existingSession.getCreated_at())) {
                existingSession.setCreated_at(session.getCreated_at());
            }
            if(session.getUpdated_at() != null && !Objects.equals(session.getUpdated_at(),
                    existingSession.getUpdated_at())) {
                existingSession.setUpdated_at(session.getUpdated_at());
            }
            if(!session.getSession_type().isEmpty() && !session.getSession_type().isBlank() && !Objects.equals(session.getSession_type(), existingSession.getSession_type())) {
                existingSession.setSession_type(session.getSession_type());
            }
        }
        return this.sessionRepository.save(existingSession);
    }

    public void deleteSession(Session session) {
        this.sessionRepository.delete(session);
    }
}
