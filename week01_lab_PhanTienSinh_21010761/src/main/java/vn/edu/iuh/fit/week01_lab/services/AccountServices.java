package vn.edu.iuh.fit.week01_lab.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01_lab.entities.*;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;
import vn.edu.iuh.fit.week01_lab.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.week01_lab.repositories.LogRepository;
import vn.edu.iuh.fit.week01_lab.repositories.RoleRepository;

import java.util.List;

public class AccountServices {


    private final AccountRepository accountRepository;
    private final LogRepository logRepository;
    private final GrantAccessRepository accessRepository;
    private final RoleRepository roleRepository;

    public AccountServices() {
        accountRepository = new AccountRepository();
        logRepository = new LogRepository();
        accessRepository = new GrantAccessRepository();
        roleRepository = new RoleRepository();
    }

    public boolean verifyAccount(String account_id, String password) {
        Account account = accountRepository.findAccountByIdPassword(account_id, password);
        return account != null;
    }

    public boolean checkExistsAccount(Account account) {
        return accountRepository.findAccountById(account.getAccount_id()) != null;
    }

    public boolean insertAccount(Account account) {
        if(checkExistsAccount(account)) {
            return false;
        } else {
            return accountRepository.insertAccount(account);
        }
    }

    public boolean updateAccount(Account account) {
        if (checkExistsAccount(account)) {
            return accountRepository.updateAccount(account);
        } else {
            return false;
        }
    }

    public Account getInforAccount(String account_id) {
        return accountRepository.findAccountById(account_id);
    }

    public List<Account> getAllInforAccount() {
        return accountRepository.findAll();
    }

    public boolean deleteAccount(Account account) {
        return accountRepository.updateStatusDelete(account.getAccount_id());
    }

    // write log the account when user login successfully and log out
    public boolean writeLog(Log log) {
       return logRepository.insertLog(log);
    }


    public List<Account> getAllAccountByRole(String roleId) {
        return accountRepository.findAccountsByRole(roleId);
    }

    public boolean setAccessByAcc(String account_id, String role_id) {
        if(accessRepository.exists(account_id, role_id)) {
            return false;
        }
        Account account = accountRepository.findAccountById(account_id);
        Role role = roleRepository.getRoleById(role_id);
        GrantAccess grantAccess = new GrantAccess();
        grantAccess.setAccount(account);
        grantAccess.setRole(role);
        grantAccess.setIs_grant(IsGrant.enable);
        return accessRepository.insertGrantAccess(grantAccess);
    }

    public boolean editRoleByAcc(String account_id, String role_id) {
        Account account = accountRepository.findAccountById(account_id);
        Role role = roleRepository.getRoleById(role_id);
        if(accessRepository.exists(account_id, role_id)) {
            GrantAccess grantAccess = new GrantAccess();
            grantAccess.setAccount(account);
            grantAccess.setRole(role);
            grantAccess.setIs_grant(IsGrant.enable);
            return accessRepository.update(grantAccess);
        }
        return false;
    }
}
