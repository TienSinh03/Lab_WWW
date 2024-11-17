package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.JobSkillIdDto;
import vn.edu.iuh.fit.backend.ids.JobSkillId;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JobSkillIdMapper {
    JobSkillId toEntity(JobSkillIdDto jobSkillIdDto);

    JobSkillIdDto toDto(JobSkillId jobSkillId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JobSkillId partialUpdate(JobSkillIdDto jobSkillIdDto, @MappingTarget JobSkillId jobSkillId);
}