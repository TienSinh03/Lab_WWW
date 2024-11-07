package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.backend.services.CandidateSkillService;

@Service
public class CandidateSkillImplService implements CandidateSkillService {

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public void save(CandidateSkill candidateSkill){candidateSkillRepository.save(candidateSkill);}
}
