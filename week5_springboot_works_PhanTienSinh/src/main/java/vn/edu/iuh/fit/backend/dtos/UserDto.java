package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.User}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class UserDto implements Serializable {
    Long id;
    String password;
    String username;
    List<RoleDto> roles;
}