/**
 * @ (#) CandidateMapper.java      10/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.models.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/17/2024
 */
public class CandidateMapper implements RowMapper<Candidate> {

    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(rs.getInt("candidate_id"));
        candidate.setFullName(rs.getString("first_name") + " " + rs.getString("middle_name") + " " + rs.getString("last_name"));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setAddress(rs.getString("address"));
        candidate.setPhone(rs.getString("phone"));
        candidate.setEmail(rs.getString("email"));
        return candidate;
    }
}
