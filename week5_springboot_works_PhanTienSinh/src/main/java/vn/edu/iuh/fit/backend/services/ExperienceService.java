package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.entities.Experience;


public interface ExperienceService {
    void getAll();
    void save(Experience experience);
}
