package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.util.AppUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Candidate {

    private int id;
    private String fullName;
    private LocalDate dob;

    private String email;

    private String address;

    private String phone;

    public String getFirstName() {
       return AppUtil.splitName(fullName)[0];
    }

    public String getMiddleName() {
       return AppUtil.splitName(fullName)[1];
    }

    public String getLastName() {
       return AppUtil.splitName(fullName)[2];
    }


}