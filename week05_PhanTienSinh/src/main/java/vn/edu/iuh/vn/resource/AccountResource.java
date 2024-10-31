package vn.edu.iuh.vn.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.vn.models.Account;
import vn.edu.iuh.vn.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountResource {

    private final AccountService accountService;

    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{balance}/{numberPage}/{size}")
    public ResponseEntity<List<Account>> findByBalanceGreaterThan(@PathVariable int balance, @PathVariable int numberPage, @PathVariable int size) {
        List<Account> accounts =  accountService.findByBalanceGreaterThan( numberPage, size, balance);
        return ResponseEntity.ok(accounts);
    }

}
