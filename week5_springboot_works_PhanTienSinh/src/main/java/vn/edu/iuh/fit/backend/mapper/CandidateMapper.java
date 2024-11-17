package vn.edu.iuh.fit.backend.mapper;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.CandidateDto;
import vn.edu.iuh.fit.backend.models.Candidate;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, CandidateSkillMapper.class, ExperienceMapper.class, AddressMapper.class})
public interface CandidateMapper {
    Candidate toEntity(CandidateDto candidateDto);

    CandidateDto toDto(Candidate candidate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Candidate partialUpdate(CandidateDto candidateDto, @MappingTarget Candidate candidate);
}