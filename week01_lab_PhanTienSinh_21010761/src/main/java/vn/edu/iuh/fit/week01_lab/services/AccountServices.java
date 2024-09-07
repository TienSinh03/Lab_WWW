package vn.edu.iuh.fit.week01_lab.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01_lab.entities.Account;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;

public class AccountServices {

    @Inject
    private AccountRepository accountRepository;

    public boolean verifyAccount(String account_id, String password) {
        Account account = accountRepository.findAccountByIdPassword(account_id, password);
        return account != null;
    }

    public Account getInforAccount(String account_id) {
        return accountRepository.findAccountById(account_id);
    }

    public Account getAllInforAccount() {
        return accountRepository.findAll();
    }

    // write log the account when user login successfully and log out
    public void writeLog(Account account, String action) {

    }



}
