package vn.edu.iuh.fit.week01_lab.services;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.Role;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;
import vn.edu.iuh.fit.week01_lab.repositories.RoleRepository;

public class RoleServices {
    @Inject
    private RoleRepository roleRepository;

    public Role getRoleByIdAccount(String account_id) {
        return roleRepository.getRoleByIdAccount(account_id);
    }
}
