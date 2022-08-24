package com.programming.dmaker.type;

import com.programming.dmaker.entity.Developer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperLevel {

    NEW("신입 개발자"),
    JUNIOR("주니어 개발자"),
    MID("미드레벨 개발자"),
    SENIOR("시니어 개발자"),
    LEAD("리드 개발자");


    private final String description;

}
