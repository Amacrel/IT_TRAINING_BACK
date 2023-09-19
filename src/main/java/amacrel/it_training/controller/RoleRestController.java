package amacrel.it_training.controller;

import amacrel.it_training.dao.RoleDao;
import amacrel.it_training.entity.Role;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@Data
public class RoleRestController {

    @Autowired
    private RoleDao roleDao;


    @GetMapping("/")
    public List<Role> getRoles() {
        return this.roleDao.getRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        Optional<Role> role = roleDao.getRoleById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Role createRole(@RequestBody Role role) {
        return roleDao.createRole(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role updatedRole) {
        Optional<Role> existingRole = roleDao.getRoleById(id);
        return existingRole.map(role -> ResponseEntity.ok(roleDao.updateRole(id, updatedRole)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable int id) {
        Optional<Role> role = roleDao.getRoleById(id);

        if (role.isPresent()) {
            roleDao.deleteRole(role.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
