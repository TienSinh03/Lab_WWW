/**
 * @ (#) UserDTO.java      11/12/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/12/2024
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private Instant registeredAt;
    private Instant lastLogin;
    private String intro;
    private String profile;
}
