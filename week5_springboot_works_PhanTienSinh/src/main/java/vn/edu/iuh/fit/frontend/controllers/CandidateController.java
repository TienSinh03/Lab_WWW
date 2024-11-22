package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.dtos.PageDto;
import vn.edu.iuh.fit.backend.entities.*;
import vn.edu.iuh.fit.backend.repositories.IAddressRepository;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateServices;
import vn.edu.iuh.fit.backend.services.CandidateSkillService;
import vn.edu.iuh.fit.backend.services.ExperienceService;
import vn.edu.iuh.fit.backend.services.SkillService;
import vn.edu.iuh.fit.frontend.models.CandidateModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
@SessionAttributes("userLogin")
public class CandidateController {

    @Autowired
    private CandidateModels candidateModels;

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

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }

    @GetMapping("")
    public String showCandidateListPaging(HttpSession session, Model model, @RequestParam( defaultValue = "0",required = false)Integer pageNo,
                                          @RequestParam(defaultValue="10",required = false) Integer pageSize) {

        if(pageNo == null) {
            pageNo = 0;
        }
        
        if(pageSize == null) {
            pageSize = 10;
        }

        PageDto<CandidateDto> candidatePage = candidateModels.getCandidates(pageNo, pageSize); // get the page of candidates
        model.addAttribute("candidatePage", candidatePage);

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
}
