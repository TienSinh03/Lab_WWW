package vn.edu.iuh.vn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "account_number", length = 64, nullable = false, unique = true)
    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("balance")
    private double balance;

    @Column(length = 100, nullable = false, unique = true)
    @JsonProperty("email")
    private String email;

    public Account(String owner, String email, double balance) {
        this.accountNumber = UUID.randomUUID().toString();
        this.owner = owner;
        this.email = email;
        this.balance = balance;
    }
}
