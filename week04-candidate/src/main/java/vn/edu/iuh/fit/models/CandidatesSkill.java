package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CandidatesSkill {

    private Candidate candidate;
    private Skill skill;
    private Integer level;

}