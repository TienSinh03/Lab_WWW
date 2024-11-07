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
        return null;
    }

    private List<SkillType> suggestSkillTypes(SkillType lastSkillType) {
        return null;
    }

    @Override
    public Optional<Skill> getSkillById(Long id) {
        return repo.findById(id);
    }
}
