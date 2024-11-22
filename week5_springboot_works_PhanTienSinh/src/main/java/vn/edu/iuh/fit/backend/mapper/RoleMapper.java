package vn.edu.iuh.fit.backend.mapper;

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.RoleDto;
import vn.edu.iuh.fit.backend.entities.Role;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/7/2024
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}