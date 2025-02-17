package service;

import jakarta.persistence.EntityNotFoundException;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;


import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    //получить список всех ролей
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // получить роль по id
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    // создание роли
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}