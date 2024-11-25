/**
 * @ (#) JobController.java      11/8/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.entities.Job;

import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.repositories.IJobRepository;
import vn.edu.iuh.fit.backend.services.JobServices;
import vn.edu.iuh.fit.frontend.models.CompanyModels;
import vn.edu.iuh.fit.frontend.models.JobModels;
import vn.edu.iuh.fit.frontend.models.SkillModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/8/2024
 */
@Controller
@RequestMapping("/jobs")
@SessionAttributes("userLogin")
public class JobController {
    @Autowired
    private JobServices jobServices;

    @Autowired
    private IJobRepository jobRepository;

    @Autowired
    private JobModels jobModels;
    @Autowired
    private SkillModels skillModels;

    @Autowired
    private CompanyModels companyModels;

    @GetMapping("")
    public String showJobsPaging(HttpSession session,Model model, @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                 @RequestParam(defaultValue = "8", required = false) Integer pageSize) {
        UserDto user = session.getAttribute("userLogin") != null ? (UserDto) session.getAttribute("userLogin") : null;
        CompanyDto companyDto = companyModels.getCompanyById(user.getId());
        if(pageNo == null) {
            pageNo = 0;
        }

        if(pageSize == null) {
            pageSize = 8;
        }


        assert user != null;
        PageDto<JobDto> jobPage = jobModels.getJobsByCompanyI_Paging(user.getId(), pageNo, pageSize);
        model.addAttribute("jobs", jobPage);
        model.addAttribute("company", companyDto);

        return "company/job/jobs";
    }



    @GetMapping({"/list"})
    public String showJobsNoPaging(Model model, @RequestParam("companyId") Long companyId) {
        System.out.println(companyId);
        List<JobDto> jobPage = jobServices.getJobsByCompanyIda(companyId);
        model.addAttribute("jobPage", jobPage);
        System.out.println(jobPage.toString());
        return "company/job/jobs";
    }

    @GetMapping({"/edit/{jobId}", "/add"})
    public String actionFormJob(HttpSession session,Model model,
                                @ModelAttribute JobDto jobDto,
                                @PathVariable(required = false) Long jobId,
                                @RequestParam(required = false) String action,
                                @RequestParam(required = false, defaultValue = "0") Integer numTagSkill) {

        UserDto user = session.getAttribute("userLogin") != null ? (UserDto) session.getAttribute("userLogin") : null;
        CompanyDto companyDto = companyModels.getCompanyById(user.getId());
        if (jobId !=null) {
            jobDto = jobModels.getJobById(jobId);
        } else {
            List<JobSkillDto> jobSkills = new ArrayList<>();
            jobSkills.add(new JobSkillDto());

            jobDto = new JobDto();
            jobDto.setCompany(companyDto);
            jobDto.setJobSkills(jobSkills);
        }

        List<SkillDto> skills = skillModels.getSkills();
        List<SkillLevel> skillLevels = List.of(SkillLevel.values());

        model.addAttribute("job", jobDto);
        model.addAttribute("skills", skills);
        model.addAttribute("skillLevels", skillLevels);


        if("newTagSkill".equals(action)) {
            for (int i = 0; i < numTagSkill; i++) {
                JobSkillDto jobSkillDto = new JobSkillDto();
                jobSkillDto.setSkill(new SkillDto());
                jobSkillDto.getSkill().setId((long) -i);
                jobDto.getJobSkills().add(jobSkillDto);
            }
        }

        model.addAttribute("numTagSkill", numTagSkill);
        return "company/job/job-form";
    }

    @PostMapping("/save")
    public String saveJob(HttpSession session, @ModelAttribute JobDto jobDto) {
        jobModels.saveaJob(jobDto);
        return "redirect:/jobs";
    }


}
