/**
 * @ (#) RecruitmentController.java      11/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.resources.JobResources;
import vn.edu.iuh.fit.frontend.models.CandidateModels;
import vn.edu.iuh.fit.frontend.models.CompanyModels;
import vn.edu.iuh.fit.frontend.models.JobModels;

import java.util.List;
import java.util.Objects;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/25/2024
 */
@Controller
@RequestMapping("/recruitment")
public class RecruitmentController {
    @Autowired
    private CandidateModels candidateModels;
    @Autowired
    private CompanyModels companyModels;
    @Autowired
    private JobModels jobModels;

    @GetMapping("/job-detail/{jobId}")
    public String showJobDetail(HttpSession session, Model model, @PathVariable(required = false) Long jobId) {
        UserDto user = (UserDto) session.getAttribute("userLogin");
        JobDto job = jobModels.getJobById(jobId);

        if(user != null) {
            CandidateDto candidate = candidateModels.getCandidateById(user.getId());

            // skills lack
            List<JobSkillDto> skillsOfJob = job.getJobSkills();
            List<JobSkillDto> skillsOfJobLack = skillsOfJob.stream()
                    .map((value) -> {
                        for(CandidateSkillDto skill : candidate.getCandidateSkills()) {
                            if(skill.getSkill().getId().equals(value.getSkill().getId())) { // Nếu có skill candidate trong job thi return null
                                return null;
                            }
                        }
                        return value; // Nếu không có skill candidate trong job thì return skill đó
                    }).filter(Objects::nonNull).toList();

            model.addAttribute("user", candidate);
            model.addAttribute("skillsOfJobLack", skillsOfJobLack);
        } else {
            model.addAttribute("user", null);
        }



        model.addAttribute("job", job);
        return "recruitment/job-detail";
    }

    @GetMapping("/recommend-job")
    public String showJobsRecommendationForCandidate(HttpSession session, Model model,
                            @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                            @RequestParam(defaultValue = "9", required = false) Integer pageSize) {
        UserDto user = (UserDto) session.getAttribute("userLogin");
        System.out.println("User: " + user);

        if(user != null) {
            CandidateDto candidate = candidateModels.getCandidateById(user.getId());
            model.addAttribute("user", candidate);
            if(pageNo == null) {
                pageNo = 0;
            }
            if(pageSize == null) {
                pageSize = 9;
            }

            List<CompanyDto> companies = companyModels.getCompanies();
            PageDto<JobDto> jobs = jobModels.findJobsForCandidateWithSkillLevel(candidate.getId(), pageNo, pageSize);

            // Tính toán phần pagination
            int start = Math.max(0, pageNo - 4); // Bắt đầu từ trang lớn hơn hoặc bằng 0
            int end = Math.min(jobs.getTotalPages() - 1, pageNo + 5); // Không vượt quá tổng số trang - 1


            model.addAttribute("jobs", jobs);
            model.addAttribute("companies", companies);
            model.addAttribute("action", "recommend-job");

            model.addAttribute("start", start); // Gửi giá trị start của pagination
            model.addAttribute("end", end);     // Gửi giá trị end của pagination
        } else {
            model.addAttribute("user", null);
        }
        return "index";
    }
}
