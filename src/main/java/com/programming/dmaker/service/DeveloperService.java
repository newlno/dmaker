package com.programming.dmaker.service;

import com.programming.dmaker.dto.request.DeveloperRequestDto;
import com.programming.dmaker.dto.response.AllDeveloperResponseDto;
import com.programming.dmaker.dto.response.DeveloperResponseDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.entity.Developer;
import com.programming.dmaker.exception.AllExceptionNaming;
import com.programming.dmaker.repository.DeveloperRepository;
import com.programming.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeveloperService{

    private final DeveloperRepository developerRepository;

    @Transactional
    public ResponseDto<?> createDeveloper(DeveloperRequestDto requestDto) {
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.setDeveloperLevel(requestDto.getExperienceYears()))
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

    @Transactional(readOnly = true)
    public ResponseDto<?> getDeveloper (Long developerId) {
        Developer developer = isPresentDev(developerId);
        if (developer == null) {
            return ResponseDto.fail(AllExceptionNaming.CANNOT_FIND_DEV);
        }
        return ResponseDto.success(developerResponseDtobuilder(developer));
    }

    @Transactional
    public ResponseDto<?> updateDeveloper (Long developerId,
                                           DeveloperRequestDto requestDto){
        Developer developer = isPresentDev(developerId);
        if (developer == null) {
            return ResponseDto.fail(AllExceptionNaming.CANNOT_FIND_DEV);
        }
        developer.updateDeveloper(requestDto);
        developerRepository.save(developer);
        return ResponseDto.success(developerResponseDtobuilder(developer));
    }

    @Transactional
    public ResponseDto<?> deleteDeveloper(Long developerId){
        Developer developer = isPresentDev(developerId);
        if (developer == null) {
            return ResponseDto.fail(AllExceptionNaming.CANNOT_FIND_DEV);
        }
        developerRepository.delete(developer);
        return ResponseDto.success(developerId + DELETE_DEV);
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
                    .build();
            allDeveloperDtoList.add(allDeveloperResponseDto);
        }
        return allDeveloperDtoList;
    }

    @Transactional(readOnly = true)
    public Developer isPresentDev(Long id) {
        Optional<Developer> optionalDeveloper = developerRepository.findById(id);
        return optionalDeveloper.orElse(null);
    }

    public DeveloperResponseDto developerResponseDtobuilder(Developer developer){
        return DeveloperResponseDto.builder()
                .id(developer.getId())
                .name(developer.getName())
                .age(developer.getAge())
                .skill(developer.getSkill())
                .experienceYears(developer.getExperienceYears())
                .developerLevel(DeveloperLevel.setDeveloperLevel(developer.getExperienceYears()))
                .build();
    }

    public static final String DELETE_DEV = " 번 ID 개발자를 삭제했습니다.";
}
