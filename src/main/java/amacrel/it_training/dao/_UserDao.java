package amacrel.it_training.dao;

import amacrel.it_training.entity._User;
import amacrel.it_training.repository._UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class _UserDao {
    @Autowired
    private _UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<_User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<_User> getUserById(int id) {
        return this.userRepository.findById(id);
    }

    public void createUser(_User newUser) {
        String password = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(password);
        this.userRepository.save(newUser);
    }

    public void updateUser(_User user) {
        if (this.getUserById(user.getId()).isPresent()) {
            _User existingUser = this.getUserById(user.getId()).get();
            if (!user.getPassword().equals("") && !Objects.equals(user.getPassword(), existingUser.getPassword())) {
                existingUser.setPassword(user.getPassword());
            }
            if (!user.getEmail().equals("") && !Objects.equals(user.getEmail(), existingUser.getEmail())) {
                existingUser.setEmail(user.getEmail());
            }
            if (!user.getFirstname().equals("") && !Objects.equals(user.getFirstname(), existingUser.getFirstname())) {
                existingUser.setFirstname(user.getFirstname());
            }
            if (!user.getLastname().equals("") && !Objects.equals(user.getLastname(), existingUser.getLastname())) {
                existingUser.setLastname(user.getLastname());
            }
            if (user.getBirthdate() != null && !Objects.equals(user.getBirthdate(), existingUser.getBirthdate())) {
                existingUser.setBirthdate(user.getBirthdate());
            }
            if (user.getRoles() != null && !Objects.equals(user.getRoles(), existingUser.getRoles())) {
                existingUser.setRoles(user.getRoles());
            }
            if (user.getEvaluations() != null && !Objects.equals(user.getEvaluations(), existingUser.getEvaluations())) {
                existingUser.setEvaluations(user.getEvaluations());
            }
            if (user.getSessions() != null && !Objects.equals(user.getSessions(), existingUser.getSessions())) {
                existingUser.setSessions(user.getSessions());
            }

            this.userRepository.save(existingUser);
        } else {
            this.userRepository.save(user);
        }

    }

    public void deleteUser(_User user) {
        this.userRepository.delete(user);
    }

    public _User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }


}
