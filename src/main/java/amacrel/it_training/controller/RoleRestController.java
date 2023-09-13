package amacrel.it_training.controller;

import amacrel.it_training.dao.RoleDao;
import amacrel.it_training.entity.Role;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@Data
public class RoleRestController {

    private RoleDao roleDao;

    public RoleRestController(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @GetMapping("/all")
    public List<Role> getRoles() {
        return this.roleDao.getRoles();
    }

    @GetMapping("/{id}/")
    public Optional<Role> getRoleById(@PathVariable int id) {
        return this.roleDao.getRoleById(id);
    }

    @PostMapping("/create")
    public void createRole(@RequestBody Role role) {
        this.roleDao.createRole(role);
    }

    @PutMapping("/update")
    public void updateRole(@RequestBody Role role) {
        this.roleDao.updateRole(role);
    }

    @DeleteMapping("/delete")
    public void deleteRole(@RequestBody Role role) {
        this.roleDao.deleteRole(role);
    }


}
