package vn.edu.iuh.fit.backend.mapper;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.CandidateSkillIdDto;
import vn.edu.iuh.fit.backend.ids.CandidateSkillId;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CandidateSkillIdMapper {
    CandidateSkillId toEntity(CandidateSkillIdDto candidateSkillIdDto);

    CandidateSkillIdDto toDto(CandidateSkillId candidateSkillId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CandidateSkillId partialUpdate(CandidateSkillIdDto candidateSkillIdDto, @MappingTarget CandidateSkillId candidateSkillId);
}