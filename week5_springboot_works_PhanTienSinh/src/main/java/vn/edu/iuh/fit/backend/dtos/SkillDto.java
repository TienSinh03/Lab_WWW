package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillType;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.Skill}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SkillDto implements Serializable {
    Long id;
    String skillDescription;
    String skillName;
    SkillType type;
}