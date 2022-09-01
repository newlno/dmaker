package com.programming.dmaker.entity;

import com.programming.dmaker.dto.request.DeveloperRequestDto;
import com.programming.dmaker.type.DeveloperLevel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
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
    private Long experienceYears;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private Long age;

    @NotBlank
    @Column(nullable = false)
    private String skill;

    public void updateDeveloper(DeveloperRequestDto requestDto){
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.skill = requestDto.getSkill();
        this.experienceYears = requestDto.getExperienceYears();
    }

}
