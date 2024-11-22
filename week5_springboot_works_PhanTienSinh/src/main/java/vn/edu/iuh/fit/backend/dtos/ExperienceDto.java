package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import vn.edu.iuh.fit.backend.entities.Experience;

import java.io.Serializable;
import java.time.LocalDate;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link Experience}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExperienceDto implements Serializable {
    long id;
    String companyName;
    LocalDate fromDate;
    LocalDate toDate;
    String role;
    String workDescription;
}