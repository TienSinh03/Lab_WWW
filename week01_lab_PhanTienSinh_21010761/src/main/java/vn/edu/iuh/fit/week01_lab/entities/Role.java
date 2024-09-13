package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(
                name = "Role.findRoleByIdAccount",
                query = "select r from Role r join GrantAccess ga on r.role_id = ga.role.role_id where ga.account.account_id = :account_id"
        ),
        @NamedQuery(name = "Role.findAll", query = "select r from Role r")
})
public class Role {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String role_id;
    @Column(columnDefinition = "varchar(50)")
    private String role_name;
    @Column(columnDefinition = "varchar(50)")
    private String description;
    private int status;
}
