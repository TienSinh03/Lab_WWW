package vn.edu.iuh.vn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import vn.edu.iuh.vn.models.Account;
import vn.edu.iuh.vn.repository.AccountRepository;

import java.util.Random;

@SpringBootApplication
public class DemoSpringJpaDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringJpaDataApplication.class, args);
    }

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
//        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            accountRepository.save(new Account("Owner " + i, "owner" + i + "@example.com", random.nextDouble(100000d) * 1000));
//        }
//
//        accountRepository.findAll().forEach(System.out::println);
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        accountRepository.findByBalanceGreaterThan(5000000, pageRequest).forEach(System.out::println);
    }
}
