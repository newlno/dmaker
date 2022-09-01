package com.programming.dmaker.type;

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

    public static DeveloperLevel setDeveloperLevel(Long experienceYears) {
        if (experienceYears > 10) {
            return DeveloperLevel.LEAD;
        } else if (experienceYears > 7) {
            return DeveloperLevel.SENIOR;
        } else if (experienceYears > 5) {
            return DeveloperLevel.MID;
        } else if (experienceYears > 2) {
            return DeveloperLevel.JUNIOR;
        } else {
            return DeveloperLevel.NEW;
        }
    }

}
