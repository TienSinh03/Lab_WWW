package vn.edu.iuh.fit.week01_lab.services;

import vn.edu.iuh.fit.week01_lab.entities.Account;
import vn.edu.iuh.fit.week01_lab.repositories.AccountRepository;

public class AccountServices {

    private AccountRepository accountRepository;

    public AccountServices() {
        accountRepository = new AccountRepository();
    }

    public boolean insertAccount(Account account) {
        return accountRepository.insertAccount(account);
    }



}
