package amacrel.it_training.dao;

import amacrel.it_training.entity._User;
import amacrel.it_training.repository._UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class _UserDao {
    @Autowired
    private _UserRepository userRepository;

    public List<_User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<_User> getUserById(int id) {
        return this.userRepository.findById(id);
    }

    public void createUser(_User user) {
        this.userRepository.save(user);
    }

    public void updateUser(_User user) {
        // TO-DO Check Attributes
        this.userRepository.save(user);
    }

    public void deleteUser(_User user) {
        this.userRepository.delete(user);
    }
}
