package vn.edu.iuh.fit.week01_lab.services;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.Role;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;
import vn.edu.iuh.fit.week01_lab.repositories.RoleRepository;

import java.util.List;

public class RoleServices {

    private final RoleRepository roleRepository;
    public RoleServices() {
        roleRepository = new RoleRepository();
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAllRoles();
    }

    public Role getRoleByIdAccount(String account_id) {
        return roleRepository.getRoleByIdAccount(account_id);
    }
}
