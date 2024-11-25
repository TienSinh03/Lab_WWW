/**
 * @ (#) JobImplService.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.entities.Company;
import vn.edu.iuh.fit.backend.entities.JobSkill;
import vn.edu.iuh.fit.backend.entities.Skill;
import vn.edu.iuh.fit.backend.ids.JobSkillId;
import vn.edu.iuh.fit.backend.mapper.CompanyMapper;
import vn.edu.iuh.fit.backend.mapper.JobMapper;
import vn.edu.iuh.fit.backend.entities.Job;
import vn.edu.iuh.fit.backend.mapper.JobSkillMapper;
import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.repositories.IJobRepository;
import vn.edu.iuh.fit.backend.repositories.ISkillRepository;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.backend.services.JobServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@Service
public class JobImplService implements JobServices {

    @Autowired
    private IJobRepository jobRepository;

    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private JobSkillMapper jobSkillMapper;

    @Autowired
    private ICompanyRepository companyRepository;

    @Autowired
    private ISkillRepository skillRepository;

    @Autowired
    private JobSkillRepository jobSkillRepository;


    @Override
    public PageDto<JobDto> getAllJobs(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Job> page = jobRepository.findAll(pageable);
        PageDto<JobDto> pageDto = new PageDto<>();
        if (page != null) {
            pageDto.setPage(pageNo);
            pageDto.setSize(pageSize);
            pageDto.setTotal(page.getNumberOfElements());
            pageDto.setTotalPages(page.getTotalPages());
            pageDto.setValues(page.stream().map(jobMapper::toDto).toList());
        }
        return pageDto;
    }

    @Override
    public PageDto<JobDto> getJobsByCompanyI_Paging(Long companyId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Job> page = jobRepository.findJobByCompanyId(companyId, pageable);
        PageDto<JobDto> pageDto = new PageDto<>();
        if (page != null) {
            pageDto.setPage(pageNo);
            pageDto.setSize(pageSize);
            pageDto.setTotal(page.getNumberOfElements());
            pageDto.setTotalPages(page.getTotalPages());
            pageDto.setValues(page.stream().map(jobMapper::toDto).toList());
        }
        return pageDto;
    }


    @Override
    public List<JobDto> getJobsByCompanyIda(Long companyId) {
        return jobRepository.findJobByCompany_Id(companyId).stream().map(jobMapper::toDto).toList();
    }

    @Override
    public JobDto getJobById(Long id) {
        return jobMapper.toDto(jobRepository.findById(id).orElse(null));
    }

    @Override
    public JobDto saveJob(JobDto jobDto) {
        Job job = jobMapper.toEntity(jobDto);
        if (jobDto.getCompany() != null && jobDto.getCompany().getId() != null) {
            Company company = companyRepository.findById(jobDto.getCompany().getId())
                    .orElseThrow(() -> new RuntimeException("Company not found"));
            job.setCompany(company);
        }

        jobRepository.save(job);

        if (jobDto.getJobSkills() != null) {
            List<JobSkill> jobSkills = new ArrayList<>();
            jobDto.getJobSkills().forEach(jobSkillDTO -> {

                Skill skill = new Skill();
                // find skill by id
                if (jobSkillDTO.getSkill().getId() != null) {
                    skill = skillRepository.findById(jobSkillDTO.getSkill().getId())
                            .orElseThrow(() -> new RuntimeException("Skill not found"));

                } else {
                    // create new skill
                    skill.setSkillName(jobSkillDTO.getSkill().getSkillName());
                    skill.setSkillDescription(jobSkillDTO.getSkill().getSkillDescription());
                    skill.setType(jobSkillDTO.getSkill().getType());
                    skillRepository.save(skill);
                }

                JobSkill jobSkill = jobSkillMapper.toEntity(jobSkillDTO);

                // create job skill id
                JobSkillId jobSkillId = new JobSkillId();
                jobSkillId.setJobId(job.getId());
                jobSkillId.setSkillId(skill.getId());

                jobSkill.setId(jobSkillId);
                jobSkill.setSkill(skill);
                jobSkill.setJob(job);

                jobSkillRepository.save(jobSkill);
                jobSkills.add(jobSkill);
            });
            job.setJobSkills(jobSkills);
        }
        return jobMapper.toDto(jobRepository.save(job));


    }

    @Override
    public int countJobByCompanyId(Long companyId) {
        return jobRepository.countJobByCompanyId(companyId);
    }

    @Override
    public List<JobSkillDto> getJobSkillsByJobId(Long jobId) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            return job.getJobSkills()
                    .stream()
                    .map(jobSkillMapper::toDto)
                    .toList();
        }
        return new ArrayList<>();
    }

}
