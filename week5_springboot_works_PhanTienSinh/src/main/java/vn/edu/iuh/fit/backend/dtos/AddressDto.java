package vn.edu.iuh.fit.backend.dtos;

import com.neovisionaries.i18n.CountryCode;
import lombok.*;

import java.io.Serializable;
/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/17/2024
 */
/**
 * DTO for {@link vn.edu.iuh.fit.backend.entities.Address}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto implements Serializable {
    Long id;
    String street;
    String city;
    CountryCode country;
    String number;
    String zipcode;
}