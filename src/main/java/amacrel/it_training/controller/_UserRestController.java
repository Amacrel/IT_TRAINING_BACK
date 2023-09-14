package amacrel.it_training.controller;

import amacrel.it_training.dao._UserDao;
import amacrel.it_training.entity._User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class _UserRestController {

    @Autowired
    private _UserDao userDao;

    @GetMapping("/")
    public List<_User> getUsers() {
        return userDao.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<_User> getUserById(@PathVariable int id) {
        Optional<_User> user = userDao.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public _User createUser(@RequestBody _User user) {
        return userDao.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<_User> updateUser(@PathVariable int id,@RequestBody _User updatedUser) {
        Optional<_User> existingUser = userDao.getUserById(id);
        return existingUser.map(user -> ResponseEntity.ok(userDao.updateUser(updatedUser))).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Optional<_User> user = userDao.getUserById(id);

        if(user.isPresent()) {
            userDao.deleteUser(user.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound(). build();
        }
    }

}
