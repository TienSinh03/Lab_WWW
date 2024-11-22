package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.edu.iuh.fit.backend.entities.Job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link Job}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class JobDto implements Serializable {
    Long id;
    String jobDesc;
    String jobName;
    CompanyDto company = new CompanyDto();
    List<JobSkillDto> jobSkills = new ArrayList<>();
}