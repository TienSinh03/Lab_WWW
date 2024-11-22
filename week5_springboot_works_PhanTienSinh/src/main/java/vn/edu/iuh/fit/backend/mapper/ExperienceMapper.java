package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.ExperienceDto;
import vn.edu.iuh.fit.backend.entities.Experience;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExperienceMapper {
    Experience toEntity(ExperienceDto experienceDto);

    ExperienceDto toDto(Experience experience);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Experience partialUpdate(ExperienceDto experienceDto, @MappingTarget Experience experience);
}