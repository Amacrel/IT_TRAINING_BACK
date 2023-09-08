package amacrel.it_training.dao;

import amacrel.it_training.entity.Role;
import amacrel.it_training.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public void createRole(Role role) {
        this.roleRepository.save(role);
    }

    public void updateRole(Role role) {
        // TO-DO Check Attributes
        this.roleRepository.save(role);
    }

    public void deleteRole(Role role) {
        this.roleRepository.delete(role);
    }
}
