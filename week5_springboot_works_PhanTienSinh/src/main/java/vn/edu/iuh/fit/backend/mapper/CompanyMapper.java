package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.CompanyDto;
import vn.edu.iuh.fit.backend.entities.Company;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, JobMapper.class, AddressMapper.class})
public interface CompanyMapper {
    Company toEntity(CompanyDto companyDto);

    CompanyDto toDto(Company company);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company partialUpdate(CompanyDto companyDto, @MappingTarget Company company);
}