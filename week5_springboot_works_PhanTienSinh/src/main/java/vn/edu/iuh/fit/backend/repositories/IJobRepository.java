/**
 * @ (#) ICandidateRepository.java      11/2/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.entities.Job;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/2/2024
 */
public interface IJobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.company.id = :companyId")
    Page<Job> findJobByCompanyId(Long companyId, Pageable pageable);


    @Query("SELECT j FROM Job j WHERE j.company.id = ?1")
    public List<Job> findJobByCompany_Id(Long companyId);

    @Query("SELECT COUNT(j) FROM Job j WHERE j.company.id = :companyId")
    int countJobByCompanyId(Long companyId);

    @Query("select jb from Job jb join jb.jobSkills js " +
            "join CandidateSkill cs on cs.skill.id = js.skill.id " +
            "where cs.candidate.id = :canId and cs.skillLevel >= js.skillLevel " +
            "group by jb.id" )
    public Page<Job> findJobsForCandidateWithSkillLevel(@Param("canId") Long canId, Pageable pageable);
}
