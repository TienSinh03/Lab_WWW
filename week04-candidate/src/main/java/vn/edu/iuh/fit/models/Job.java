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
public class Job {
    private Integer id;
    private String description;
    private Set<JobsSkill> jobsSkills = new LinkedHashSet<>();

}