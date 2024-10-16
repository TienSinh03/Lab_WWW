/**
 * @ (#) CandidateRepository.java      10/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repository;

import vn.edu.iuh.fit.models.Candidate;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/17/2024
 */
public interface CandidateRepository {
    public Candidate save(Candidate candidate);
    public Candidate update(Candidate candidate);
    public boolean delete(int id);
    public Candidate findById(int id);
    public List<Candidate> findAll();
}
