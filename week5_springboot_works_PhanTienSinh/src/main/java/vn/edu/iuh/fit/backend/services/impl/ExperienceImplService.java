package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Experience;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;
import vn.edu.iuh.fit.backend.services.ExperienceService;

@Service
public class ExperienceImplService implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public void getAll() {
        experienceRepository.findAll();
    }

    @Override
    public void save(Experience experience) {
        experienceRepository.save(experience);
    }
}
