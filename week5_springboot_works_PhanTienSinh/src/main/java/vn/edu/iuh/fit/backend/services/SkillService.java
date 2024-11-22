package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.dtos.SkillDto;
import vn.edu.iuh.fit.backend.entities.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
SkillDto addSkill(SkillDto skill);
List<SkillDto> getAllSkills();
List<SkillDto> suggestSkillsForCandidate(Long candidateId);
Optional<SkillDto> getSkillById(Long id);
}
