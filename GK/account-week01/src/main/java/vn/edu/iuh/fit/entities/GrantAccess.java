package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "grant_access")
@NamedQueries({
        @NamedQuery(name = "GrantAccess.updateIs_grantBy", query = "update GrantAccess g set g.is_grant = :is_grant"),
        @NamedQuery(name = "GrantAccess.exi sts", query = "select (count(g)>0) from GrantAccess g where g.role.role_id = :role_id and g.account.account_id = :account_id"),
})
public class GrantAccess {

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Id
    private Role role;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @Id
    private Account account;

    @Enumerated(EnumType.ORDINAL)
    private IsGrant is_grant;

}
