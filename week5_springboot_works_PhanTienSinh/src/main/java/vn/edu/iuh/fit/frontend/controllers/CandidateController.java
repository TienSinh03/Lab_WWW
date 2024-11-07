package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.IAddressRepository;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateServices;
import vn.edu.iuh.fit.backend.services.CandidateSkillService;
import vn.edu.iuh.fit.backend.services.ExperienceService;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

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

    @GetMapping("/list_paging")
    public String showCandidateListPaging(Model model, @RequestParam("page")Optional<Integer> page,
                                          @RequestParam("size")Optional<Integer> size) {
        int currentPage = page.orElse(1); // default page number is 1 (the first page) or get the page number from the request
        int pageSize = size.orElse(10); // default page size is 10 or get the page size from the request

        Page<Candidate> candidatePage = candidateServices.findAll(currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);

        int totalPages = candidatePage.getTotalPages(); // get the total number of pages
        if(totalPages>0) {
            List<Integer> pageNumbers= IntStream.rangeClosed(1, totalPages) // create a list of page numbers from 1 to totalPages
                    .boxed().toList();
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }

    @GetMapping("form-add-candidate")
    public ModelAndView showFormAddCandidate(Model model) {
        ModelAndView mav = new ModelAndView("candidates/add-candidate");
        Candidate candidate = new Candidate();
        CandidateSkill candidateSkill = new CandidateSkill();
        Experience experience = new Experience();
        candidate.setAddress(new Address());
        mav.addObject("candidate", candidate);
        mav.addObject("address", candidate.getAddress());
        mav.addObject("countries", CountryCode.values());
        mav.addObject("candidateSkill", candidateSkill);
        mav.addObject("skills", skillService.getAllSkills());
        mav.addObject("experience", experience);
        return mav;
    }

    @PostMapping("add")
    public String addCandidate(@ModelAttribute("candidate") Candidate candidate
            , @ModelAttribute("address") Address address
            , @ModelAttribute("candidateSkill") CandidateSkill candidateSkill
            , @ModelAttribute("experience") Experience experience
            , @RequestParam("skillId") Long skillId
            , @RequestParam("skillLevel") SkillLevel skillLevel
            ,@ModelAttribute("experience") Experience experiences) {

        System.out.println("Candidate ID: " + candidate.getId());

        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);

        Candidate canbyEmail = candidateRepository.findByEmail(candidate.getEmail());
        System.out.println("Candidate ID: " + canbyEmail.getId());
        Skill skill = skillService.getSkillById(skillId).get();
        candidateSkill.setSkill(skill);
        candidateSkill.setCandidate(canbyEmail);
        candidateSkill.setSkillLevel(skillLevel);
        candidateSkillService.save(candidateSkill);

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
