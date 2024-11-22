package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.edu.iuh.fit.backend.entities.CandidateSkill;
import vn.edu.iuh.fit.backend.entities.Experience;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.Candidate}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class CandidateDto implements Serializable {
    Long id;
    LocalDate dob;
    String email;
    String fullName;
    String phone;
    AddressDto address;
    List<Experience> experiences = new ArrayList<>();
    List<CandidateSkillDto> candidateSkills = new ArrayList<>();
}