package com.programming.dmaker.dto.response;

import com.programming.dmaker.type.DeveloperLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperResponseDto {
    private Long id;
    private String name;
    private Long age;
    private String skill;
    private Long experienceYears;
    private DeveloperLevel developerLevel;
}
