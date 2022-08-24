package com.programming.dmaker.entity;

import com.programming.dmaker.type.DeveloperLevel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Developer extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @NotBlank
    @Column(nullable = false)
    private Integer experienceYears;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private Integer age;

    @NotBlank
    @Column(nullable = false)
    private String skill;

}
