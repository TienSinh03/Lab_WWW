package vn.edu.iuh.fit.backend.mapper;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.CandidateSkillDto;
import vn.edu.iuh.fit.backend.entities.CandidateSkill;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {SkillMapper.class, CandidateSkillIdMapper.class, AddressMapper.class})
public interface CandidateSkillMapper {
    CandidateSkill toEntity(CandidateSkillDto candidateSkillDto);

    CandidateSkillDto toDto(CandidateSkill candidateSkill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CandidateSkill partialUpdate(CandidateSkillDto candidateSkillDto, @MappingTarget CandidateSkill candidateSkill);
}