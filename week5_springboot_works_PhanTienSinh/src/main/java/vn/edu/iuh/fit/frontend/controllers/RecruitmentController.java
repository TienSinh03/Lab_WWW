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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.resources.JobResources;
import vn.edu.iuh.fit.backend.services.EmailService;
import vn.edu.iuh.fit.frontend.models.CandidateModels;
import vn.edu.iuh.fit.frontend.models.CompanyModels;
import vn.edu.iuh.fit.frontend.models.JobModels;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private EmailService emailService;

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
        session.setAttribute("job", job);

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


    @PostMapping("/send-email-apply")
    public String sendEmailApply(HttpSession session, Model model, RedirectAttributes redirectAttributes
                                , @ModelAttribute("user") CandidateDto candidate
                                 , @RequestParam("cv") MultipartFile cv,
                                    @RequestParam("letter") String coverLetter
                                 ) {

        JobDto job = session.getAttribute("job") != null ? (JobDto) session.getAttribute("job") : null;
        CompanyDto companyDto = job.getCompany();

        System.out.println("Job: " + job);
        System.out.println("Candidate: " + candidate);
        System.out.println("Company: " + companyDto);
//        Long id = Long.parseLong(candidateId);
//        CandidateDto candidate = candidateModels.getCandidateById(id);

        if (candidate == null) {
            redirectAttributes.addFlashAttribute("message", "Failed to send the email.");
        } else {
            String fromEmail = candidate.getEmail();
            String subject = "Application for " + job.getJobName();
            String body = "I am writing to express my interest in the position of" +job.getJobName()+ "at"+ companyDto.getCompName()+". I believe my skills and experience align well with the requirements of this role.\n" +
                    "\n" +
                    "I have a background in IT, and I am particularly skilled in Dev. These have equipped me to contribute effectively to the goals of your team.\n" +
                    "\n" +
                    "Attached to this email, you will find my resume/CV for your review. I would be delighted to discuss how my qualifications match your needs in more detail.\n" +
                    "\n" +
                    "Thank you for considering my application. I look forward to the opportunity to contribute to "+ companyDto.getCompName()+" and am available for an interview at your earliest convenience.\n" +
                    "\n" +
                    "Best regards, \n" +
                     candidate.getFullName() +"\n" +
                    "Email: "+ candidate.getEmail()+"\n" +
                    "Phone: "+ candidate.getPhone()+"\n" +
                    "CV: "+ cv.getOriginalFilename();

            emailService.sendEmailApply(fromEmail, subject, body);

            redirectAttributes.addFlashAttribute("message", "Email has been sent successfully!");
        }


        return "redirect:/recruitment/job-detail/"+job.getId();

    }


}
