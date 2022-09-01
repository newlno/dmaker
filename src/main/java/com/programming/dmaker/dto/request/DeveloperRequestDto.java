package com.programming.dmaker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperRequestDto {
    private String name;
    private Long age;
    private Long experienceYears;
    private String skill;
}
