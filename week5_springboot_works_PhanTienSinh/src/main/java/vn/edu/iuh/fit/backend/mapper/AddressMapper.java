package vn.edu.iuh.fit.backend.mapper;


/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */

import org.mapstruct.*;
import vn.edu.iuh.fit.backend.dtos.AddressDto;
import vn.edu.iuh.fit.backend.entities.Address;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);
}