package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.CompanyDto;
import vn.edu.iuh.fit.backend.mapper.CompanyMapper;
import vn.edu.iuh.fit.backend.models.Company;

import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImplService implements CompanyService {
    @Autowired
    private ICompanyRepository repo;

    @Autowired
    private CompanyMapper mapper;

    @Override
    public List<CompanyDto> getAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<Company> getById(Long id) {
        return repo.findById(id);
    }

    public void save(Company company) {
        repo.save(company);
    }

    @Override
    public Company update(Company company) {
        return repo.findById(company.getId()).map(existingCompany -> {
            existingCompany.setCompName(company.getCompName());
            existingCompany.setAddress(company.getAddress());
            existingCompany.setPhone(company.getPhone());
            existingCompany.setEmail(company.getEmail());

            return repo.save(existingCompany);
        }).orElseThrow(() -> new IllegalArgumentException("Company not found with ID: " + company.getId()));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Company> getAllByPaging(int pageNo, int size, String sortField, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortField);
        Pageable page = PageRequest.of(pageNo, size, sort);
        return repo.findAll(page);
    }


}
