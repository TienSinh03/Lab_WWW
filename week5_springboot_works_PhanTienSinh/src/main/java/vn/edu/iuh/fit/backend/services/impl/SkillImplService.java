package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ISkillRepository;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SkillImplService implements SkillService {
    @Autowired
    private ISkillRepository repo;
    @Autowired
    private ICandidateRepository candidateRepository;

    @Override
    public Skill addSkill(Skill skill) {
        return repo.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return repo.findAll();
    }

    @Override
    public List<Skill> suggestSkillsForCandidate(Long candidateId) {
        return candidateRepository.findById(candidateId)
                .map(candidate -> {
                    List<Skill> allSkills = repo.findAll();
                    List<Skill> candidateSkills = candidate.getCandidateSkills().stream()
                            .map(CandidateSkill::getSkill)
                            .toList();

                    List<Skill> missingSkills = allSkills.stream()
                            .filter(skill -> !candidateSkills.contains(skill))
                            .toList();

                    return missingSkills.stream()
                            .filter(skill -> suggestSkillTypes(candidateSkills.get(candidateSkills.size() - 1).getType()).contains(skill.getType()))
                            .limit(10)
                            .collect(Collectors.toList());
                })
                .orElse(Collections.emptyList());
    }

    private List<SkillType> suggestSkillTypes(SkillType lastSkillType) {
        return switch (lastSkillType) {
            case UNSPECIFIC -> List.of(SkillType.TECHNICAL_SKILL, SkillType.SOFT_SKILL);
            case TECHNICAL_SKILL -> List.of(SkillType.SOFT_SKILL);
            case SOFT_SKILL -> List.of(SkillType.TECHNICAL_SKILL);
            default -> Collections.emptyList();
        };
    }

    @Override
    public Optional<Skill> getSkillById(Long id) {
        return repo.findById(id);
    }
}
