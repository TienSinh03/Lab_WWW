package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.SkillDto;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.entities.Skill;
import vn.edu.iuh.fit.backend.mapper.SkillMapper;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ISkillRepository;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.List;
import java.util.Optional;


@Service
public class SkillImplService implements SkillService {
    @Autowired
    private ISkillRepository repo;
    @Autowired
    private ICandidateRepository candidateRepository;
    @Autowired
    private SkillMapper skillMapper;

    @Override
    public SkillDto addSkill(SkillDto skill) {
        return skillMapper.toDto(repo.save(skillMapper.toEntity(skill)));
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return repo.findAll().stream()
                .map(skillMapper::toDto)
                .toList();
    }

    @Override
    public List<SkillDto> suggestSkillsForCandidate(Long candidateId) {
        return null;
    }

    private List<SkillType> suggestSkillTypes(SkillType lastSkillType) {
        return null;
    }

    @Override
    public Optional<SkillDto> getSkillById(Long id) {
        return repo.findById(id).map(skillMapper::toDto);
    }
}
