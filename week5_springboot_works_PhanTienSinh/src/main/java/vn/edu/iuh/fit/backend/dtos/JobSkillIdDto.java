package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.ids.JobSkillId }
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobSkillIdDto implements Serializable {
    Long jobId;
    Long skillId;
}