package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
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
