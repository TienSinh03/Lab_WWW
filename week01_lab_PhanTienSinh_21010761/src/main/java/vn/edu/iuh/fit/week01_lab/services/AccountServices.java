package vn.edu.iuh.fit.week01_lab.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01_lab.entities.Account;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;

import java.util.List;

public class AccountServices {

    @Inject
    private AccountRepository accountRepository;

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
    public void writeLog(Account account, String action) {

    }



}
