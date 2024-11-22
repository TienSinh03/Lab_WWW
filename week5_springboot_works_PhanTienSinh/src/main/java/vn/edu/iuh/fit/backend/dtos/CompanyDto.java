package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.Company}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDto implements Serializable {
    Long id;
    String about;
    String email;
    String compName;
    String phone;
    String webUrl;
    AddressDto address;
}