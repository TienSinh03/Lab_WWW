package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import lombok.Value;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.models.Role}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDto implements Serializable {
    Long id;
    String code;
    String name;
}