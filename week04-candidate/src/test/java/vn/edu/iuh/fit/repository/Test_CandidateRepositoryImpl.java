/**
 * @ (#) Test_CandidateRepositoryImpl.java      10/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Candidate;

import java.sql.Date;
import java.time.LocalDate;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/17/2024
 */
@SpringBootTest
public class Test_CandidateRepositoryImpl {
    private CandidateRepository candidateRepository;

    @Autowired
    public Test_CandidateRepositoryImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Test
    public void testSave() {
        Candidate candidate = new Candidate();
        candidate.setFullName("Phan Tien Sinh");
        candidate.setDob(LocalDate.of(1999, 10, 17));
        candidate.setAddress("HCM");
        candidate.setPhone("0123456789");
        candidate.setEmail("sinh@gmail.com");

        Candidate result = candidateRepository.save(candidate);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testUpdate() {
        Candidate candidate = new Candidate();
        candidate.setId(1);
        candidate.setFullName("Phan Tien Sinh");
        candidate.setDob(LocalDate.of(1999, 10, 17));
        candidate.setAddress("Phu Yen");
        candidate.setPhone("0123456789");
        candidate.setEmail("sinh@gmail.com");

        Candidate result = candidateRepository.update(candidate);
        Candidate actual = candidateRepository.findById(1);
        Assertions.assertEquals(actual.getAddress(), "Phu Yen");
    }

    @Test
    public void testFindById() {
        Candidate result = candidateRepository.findById(1);
        Assertions.assertEquals(result.getId(), 1);
    }

    @Test
    public void testDelete() {
        boolean result = candidateRepository.delete(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void testFindAll() {
        Assertions.assertEquals(candidateRepository.findAll().size(), 2);
    }
}
