package amacrel.it_training.repository;

import amacrel.it_training.entity._User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface _UserRepository extends JpaRepository<_User, Integer> {
    public _User findUserByUsername(String username);
}
