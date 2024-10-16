/**
 * @ (#) CandidateRepositoryImpl.java      10/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repository.CandidateRepository;
import vn.edu.iuh.fit.repository.mapper.CandidateMapper;

import javax.sql.DataSource;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/17/2024
 */
@Repository
public class CandidateRepositoryImpl implements CandidateRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Candidate save(Candidate candidate) {
        String sql = "INSERT INTO candidate (first_name, middle_name, last_name, dob, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail());
        return candidate;
    }

    @Override
    public Candidate update(Candidate candidate) {
        String sql = "UPDATE candidate SET first_name = ?, middle_name = ?, last_name = ?, dob = ?, address = ?, phone = ?, email = ? WHERE candidate_id = ?";
        jdbcTemplate.update(sql,candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getId());
        return candidate;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM candidate WHERE candidate_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public Candidate findById(int id) {
        String sql = "SELECT * FROM candidate WHERE candidate_id = ?";
        return jdbcTemplate.queryForObject(sql, new CandidateMapper(), id);
    }

    @Override
    public List<Candidate> findAll() {
        String sql = "SELECT * FROM candidate";
        return jdbcTemplate.query(sql, new CandidateMapper());
    }
}
