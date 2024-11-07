package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Experience;


public interface ExperienceService {
    void getAll();
    void save(Experience experience);
}
