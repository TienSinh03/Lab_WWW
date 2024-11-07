package vn.edu.iuh.fit.backend.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;


public class CandidateSkillId implements Serializable {
    private Skill skill;
    private Candidate candidate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateSkillId that = (CandidateSkillId) o;

        if (!skill.equals(that.skill)) return false;
        return candidate.equals(that.candidate);
    }

    @Override
    public int hashCode() {
        int result = skill.hashCode();
        result = 31 * result + candidate.hashCode();
        return result;
    }

}