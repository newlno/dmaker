package com.programming.dmaker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DMakerRequestDto {
    private String name;
    private Integer age;
    private Integer experienceYears;
    private String skill;
}
