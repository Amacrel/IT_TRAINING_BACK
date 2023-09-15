package amacrel.it_training.dao;

import amacrel.it_training.entity.Role;
import amacrel.it_training.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class RoleDao {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return this.roleRepository.findAll();
    }

    public Optional<Role> getRoleById(int id) {
        return this.roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }

    public Role updateRole(int id, Role role) {
        Role existingRole = this.getRoleById(id).get();
        if (this.getRoleById(id).isPresent()) {
            if (!role.getRights().isEmpty() && !role.getRights().isBlank() && !Objects.equals(role.getRights(),
                    existingRole.getRights())) {
                existingRole.setRights(role.getRights());
            }
        }
        return this.roleRepository.save(existingRole);
    }

    public void deleteRole(Role role) {
        this.roleRepository.delete(role);
    }
}
