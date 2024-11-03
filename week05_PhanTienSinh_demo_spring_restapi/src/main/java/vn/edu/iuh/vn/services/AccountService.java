package vn.edu.iuh.vn.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.vn.models.Account;

import java.util.List;


public interface AccountService {
    public List<Account> findByBalanceGreaterThan(int pageNumber, int size, int balance);
    public List<Account> findAll();
}
