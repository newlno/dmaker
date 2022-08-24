package com.programming.dmaker.service.impl;

import com.programming.dmaker.dto.request.DMakerRequestDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.entity.Developer;
import com.programming.dmaker.repository.DMakerRepository;
import com.programming.dmaker.service.DMakerService;
import com.programming.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerServiceImpl implements DMakerService {

    private final DMakerRepository DMakerRepository;

    @Override
    @Transactional
    public ResponseDto<?> createDeveloper(DMakerRequestDto requestBody) {

        Developer developer = Developer.builder()
                .developerLevel(setDeveloperLevel(requestBody.getExperienceYears()))
                .age(requestBody.getAge())
                .name(requestBody.getName())
                .skill(requestBody.getSkill())
                .build();
        DMakerRepository.save(developer);
        return ResponseDto.success(developer);
    }






    @Override
    public DeveloperLevel setDeveloperLevel(Integer experienceYears) {
        if (experienceYears > 10) {
            return DeveloperLevel.LEAD;
        } else if (experienceYears > 7) {
            return DeveloperLevel.SENIOR;
        } else if (experienceYears > 5) {
            return DeveloperLevel.MID;
        } else if (experienceYears < 2) {
            return DeveloperLevel.JUNIOR;
        } else {
            return DeveloperLevel.NEW;
        }
    }
}
