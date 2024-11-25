/**
 * @ (#) CandidateServicesImpl.java      11/7/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.mapper.CandidateMapper;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
@Service
public class CandidateServicesImpl implements CandidateServices {

    @Autowired
    private ICandidateRepository candidateRepository;

    @Autowired
    private CandidateMapper candidateMapper;

    public PageDto<CandidateDto> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Candidate> page = candidateRepository.findAll(pageable);
        PageDto<CandidateDto> pageDto = new PageDto<>();
        if (page != null) {
            pageDto.setPage(pageNo);
            pageDto.setSize(pageSize);
            pageDto.setTotal(page.getNumberOfElements());
            pageDto.setTotalPages(page.getTotalPages());
            pageDto.setValues(page.stream().map(candidateMapper::toDto).toList());
        }
        return pageDto;
    }

    @Override
    public List<CandidateDto> findAllNoPaging() {
        return candidateRepository.findAll().stream().map(candidateMapper::toDto).toList();
    }

    @Override
    public CandidateDto getByEmail(String email) {
        return candidateMapper.toDto(candidateRepository.findByEmail(email));
    }

    @Override
    public CandidateDto getCandidate(Long id) {
        return candidateMapper.toDto(candidateRepository.findById(id).orElse(null));
    }

    @Override
    public Integer countCandidates() {
        return (int) candidateRepository.count();
    }

    @Override
    public PageDto<CandidateDto> findCandidatesForJobWithSkillLevel(Long jobId, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Candidate> candidate = candidateRepository.findCandidatesForJobWithSkillLevel(jobId, pageRequest);
        PageDto<CandidateDto> pageDto = new PageDto<>();
        if (candidate != null) {
            pageDto.setPage(pageNo);
            pageDto.setSize(pageSize);
            pageDto.setTotal(candidate.getNumberOfElements());
            pageDto.setTotalPages(candidate.getTotalPages());
            pageDto.setValues(candidate.stream().map(candidateMapper::toDto).toList());
        }
        return pageDto;
    }
}
