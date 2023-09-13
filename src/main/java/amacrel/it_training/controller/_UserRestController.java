package amacrel.it_training.controller;

import amacrel.it_training.dao._UserDao;
import amacrel.it_training.entity._User;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@Data
public class _UserRestController {
    private _UserDao userDao;

    public _UserRestController(_UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/all")
    public List<_User> getUsers() {
        return this.userDao.getUsers();
    }

    @GetMapping("/{id}/")
    public Optional<_User> getUserById(@PathVariable int id) {
        return this.userDao.getUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody _User user) {
        this.userDao.createUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody _User user) {
        this.userDao.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody _User user) {
        this.userDao.deleteUser(user);
    }
}
