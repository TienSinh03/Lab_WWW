package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.config.DsConfig;

import javax.sql.DataSource;

@SpringBootApplication
public class Week04CandidateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Week04CandidateApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource.getConnection().getCatalog());
    }
}
