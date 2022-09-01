package com.programming.dmaker.service;

import com.programming.dmaker.dto.request.DeveloperRequestDto;
import com.programming.dmaker.dto.response.AllDeveloperResponseDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.entity.Developer;
import com.programming.dmaker.repository.DeveloperRepository;
import com.programming.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService{

    private final DeveloperRepository developerRepository;

    @Transactional
    public ResponseDto<?> createDeveloper(DeveloperRequestDto requestDto) {
        Developer developer = Developer.builder()
                .developerLevel(setDeveloperLevel(requestDto.getExperienceYears()))
                .age(requestDto.getAge())
                .name(requestDto.getName())
                .skill(requestDto.getSkill())
                .experienceYears(requestDto.getExperienceYears())
                .build();
        developerRepository.save(developer);
        return ResponseDto.success(developer);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getAllDeveloper () {
        List<AllDeveloperResponseDto> allDeveloperDtoList = getAllDeveloperResponseDto();
        return ResponseDto.success(allDeveloperDtoList);
    }






    private List<AllDeveloperResponseDto> getAllDeveloperResponseDto() {
        List<Developer> developerList = developerRepository.findAllByOrderByCreatedAtDesc();
        List<AllDeveloperResponseDto> allDeveloperDtoList = new ArrayList<>();
        for (Developer developer : developerList) {
            AllDeveloperResponseDto allDeveloperResponseDto = AllDeveloperResponseDto.builder()
                    .id(developer.getId())
                    .name(developer.getName())
                    .age(developer.getAge())
                    .skill(developer.getSkill())
                    .experienceYears(developer.getExperienceYears())
                    .build();
            allDeveloperDtoList.add(allDeveloperResponseDto);
        }
        return allDeveloperDtoList;
    }



    public DeveloperLevel setDeveloperLevel(Long experienceYears) {
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
