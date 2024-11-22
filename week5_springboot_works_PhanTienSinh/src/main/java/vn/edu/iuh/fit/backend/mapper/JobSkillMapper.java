package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.JobSkillDto;
import vn.edu.iuh.fit.backend.entities.JobSkill;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {SkillMapper.class, JobMapper.class, JobSkillIdMapper.class})
public interface JobSkillMapper {
    JobSkill toEntity(JobSkillDto jobSkillDto);

    JobSkillDto toDto(JobSkill jobSkill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JobSkill partialUpdate(JobSkillDto jobSkillDto, @MappingTarget JobSkill jobSkill);
}