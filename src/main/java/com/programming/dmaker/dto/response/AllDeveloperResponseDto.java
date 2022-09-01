package com.programming.dmaker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AllDeveloperResponseDto {

    private Long id;
    private String name;
    private Long age;
    private Long experienceYears;
    private String skill;

}