package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import lombok.Value;
import vn.edu.iuh.fit.backend.models.Experience;

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
public class ExperienceDto implements Serializable {
    long id;
    String companyName;
    LocalDate fromDate;
    LocalDate toDate;
    String role;
    String workDescription;
}