package vn.edu.iuh.fit.backend.dtos;

import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.JobSkill}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JobSkillDto implements Serializable {
    JobSkillIdDto id;
    SkillDto skill;
    SkillLevel skillLevel;
    String moreInfo;
}