package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.converters.SkillLevelConverter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.ids.JobSkillId;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_skill")
@IdClass(JobSkillId.class)
public class JobSkill implements Serializable {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    @JsonProperty("skill")
    private Skill skill;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    @JsonIgnore
    private Job job;;

    @Column(name = "skill_level", nullable = false)
    @Convert(converter = SkillLevelConverter.class)
    @JsonProperty("skill_level")
    private SkillLevel skillLevel;

    @Column(name = "more_infos", length = 1000)
    @JsonProperty("more_infos")
    private String moreInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkill jobSkill)) return false;
        return Objects.equals(skill, jobSkill.skill) && Objects.equals(job, jobSkill.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, job);
    }
}