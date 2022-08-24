package com.programming.dmaker.service;

import com.programming.dmaker.dto.request.DMakerRequestDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.type.DeveloperLevel;


public interface DMakerService {

    ResponseDto<?> createDeveloper(DMakerRequestDto requestBody);

    DeveloperLevel setDeveloperLevel(Integer experienceYears);
}
