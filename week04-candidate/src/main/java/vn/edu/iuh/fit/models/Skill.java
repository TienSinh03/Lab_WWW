package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skill {

    private Integer id;

    private String skillName;

    private String description;

    private String field;


}