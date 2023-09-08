package amacrel.it_training.repository;

import amacrel.it_training.entity._User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface _UserRepository extends JpaRepository<_User, Integer> {
}
