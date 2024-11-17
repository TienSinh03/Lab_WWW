package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateSkillIdDto implements Serializable {
    Long skillId;
    Long canId;
}