package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.dtos.*;
import vn.edu.iuh.fit.backend.entities.*;
import vn.edu.iuh.fit.backend.repositories.IAddressRepository;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.services.*;
import vn.edu.iuh.fit.frontend.models.CandidateModels;
import vn.edu.iuh.fit.frontend.models.CompanyModels;
import vn.edu.iuh.fit.frontend.models.JobModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
@SessionAttributes("userLogin")
public class CandidateController {

    @Autowired
    private CandidateModels candidateModels;

    @Autowired
    private JobModels jobModels;

    @Autowired
    private CompanyModels companyModels;

    @Autowired
    private CandidateServices candidateServices;

    @Autowired
    public ICandidateRepository candidateRepository;

    @Autowired
    public IAddressRepository addressRepository;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CandidateSkillService candidateSkillService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private EmailService emailService;


    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }

    @GetMapping("")
    public String showCandidateListPaging(HttpSession session, Model model, @RequestParam( defaultValue = "0",required = false)Integer pageNo,
                                          @RequestParam(defaultValue="10",required = false) Integer pageSize) {

        UserDto user = session.getAttribute("userLogin") != null ? (UserDto) session.getAttribute("userLogin") : null;
        CompanyDto companyDto = companyModels.getCompanyById(user.getId());
        PageDto<JobDto> jobPage = jobModels.getJobsByCompanyI_Paging(user.getId(), pageNo, pageSize);


        if(pageNo == null) {
            pageNo = 0;
        }
        
        if(pageSize == null) {
            pageSize = 10;
        }

        PageDto<CandidateDto> candidatePage = candidateModels.getCandidates(pageNo, pageSize); // get the page of candidates
        model.addAttribute("candidatePage", candidatePage);
        model.addAttribute("jobs", jobPage);

        return "candidates/candidates-paging";
    }

    @GetMapping("form-add-candidate")
    public ModelAndView showFormAddCandidate(Model model) {
        ModelAndView mav = new ModelAndView("candidates/add-candidate");
        Candidate candidate = new Candidate();
        candidate.setCandidateSkills(new ArrayList<>());
        Experience experience = new Experience();
        candidate.setAddress(new Address());
        mav.addObject("candidate", candidate);
        mav.addObject("address", candidate.getAddress());
        mav.addObject("countries", CountryCode.values());
        mav.addObject("skills", skillService.getAllSkills());
        mav.addObject("experience", experience);
        return mav;
    }

    @PostMapping("/add")
    public String addCandidate(@ModelAttribute("candidate") Candidate candidate,
                               @ModelAttribute("address") Address address,
                               @ModelAttribute("experience") Experience experience) {
        // Khởi tạo danh sách nếu candidateSkills là null
        if (candidate.getCandidateSkills() == null) {
            candidate.setCandidateSkills(new ArrayList<>());
        }
        candidate.getCandidateSkills().removeIf(Objects::isNull);

        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);

        Candidate canbyEmail = candidateRepository.findByEmail(candidate.getEmail());
        System.out.println(candidate.getCandidateSkills());

        // Lưu từng CandidateSkill
        for (CandidateSkill candidateSkill : candidate.getCandidateSkills()) {
            if (candidateSkill.getSkill() != null && candidateSkill.getSkillLevel() != null) { // Kiểm tra null trước khi lưu
                candidateSkill.setCandidate(canbyEmail);
                candidateSkillService.save(candidateSkill);
            }
        }

        experience.setCandidate(canbyEmail);
        experienceService.save(experience);

        return "redirect:/candidates/list_paging";
    }



    @GetMapping("form-update-candidate/{id}")
    public ModelAndView showFormEditCandidate(Model model, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("candidates/update-candidates");
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if(candidate.isPresent()) {
            mav.addObject("candidate", candidate.get());
            mav.addObject("address", candidate.get().getAddress());
            mav.addObject("countries", CountryCode.values());
        }
        return mav;
    }

    @PostMapping("edit")
    public String editCandidate(@ModelAttribute("candidate") Candidate candidate
            , @ModelAttribute("address") Address address) {
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("delete/{id}")
    public String deleteCandidate(@PathVariable("id") Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        candidateRepository.delete(candidate);
        return "redirect:/candidates/list_paging";
    }


    @GetMapping("/job/{jobId}")
    public String showNominee(HttpSession session,Model model, @PathVariable String jobId, @RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(jobId);
        Long id = Long.parseLong(jobId);
        if(pageNo == null) {
            pageNo = 0;
        }

        if(pageSize == null) {
            pageSize = 5;
        }
        PageDto<CandidateDto> candidatePage = candidateModels.findCandidatesForJobWithSkillLevel(id, pageNo, pageSize);
        model.addAttribute("candidatePage", candidatePage);
        model.addAttribute("message", null);
        session.setAttribute("job", jobModels.getJobById(id));
        System.out.println(jobModels.getJobById(id));
        return "candidates/candidates-paging";
    }

    @GetMapping("/send-email/{candidateId}")
    public String sendEmail(HttpSession session, Model model, RedirectAttributes redirectAttributes, @PathVariable String candidateId) {
        UserDto user = session.getAttribute("userLogin") != null ? (UserDto) session.getAttribute("userLogin") : null;
        CompanyDto companyDto = companyModels.getCompanyById(user.getId());

        Long id = Long.parseLong(candidateId);
        CandidateDto candidate = candidateModels.getCandidateById(id);

        JobDto job = (JobDto) session.getAttribute("job");
        if (candidate == null) {
            redirectAttributes.addFlashAttribute("message", "Failed to send the email.");
        } else {
            String toEmail = candidate.getEmail();
            String subject = "Job Invitation for " + job.getJobName();
            String body = "Dear " + candidate.getFullName() + ",\n\n" +
                    "We are excited to invite you to apply for the position of " + job.getJobName() + " at our company. " +
                    "This role requires the following skills: " + job.getJobSkills().stream()
                    .map(skill -> skill.getSkill().getSkillName())
                    .collect(Collectors.joining(", ")) + ".\n\n" +
                    "Please let us know if you're interested. \nContact to our phone: " +companyDto.getPhone()+", or email: "+companyDto.getEmail()
                    +"\n\nBest regards,\n" + companyDto.getCompName();

            emailService.sendInvitationToCandidate(toEmail, subject, body);

            redirectAttributes.addFlashAttribute("message", "Email has been sent successfully!");
        }

        String jobId = job.getId().toString();
        return "redirect:/candidates/job/"+jobId;

    }
}
