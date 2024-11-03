package vn.edu.iuh.vn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.vn.models.Account;
import vn.edu.iuh.vn.repository.AccountRepository;
import vn.edu.iuh.vn.services.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findByBalanceGreaterThan(int pageNumber, int size, int balance) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
       return accountRepository.findByBalanceGreaterThan(balance, pageRequest);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

}
