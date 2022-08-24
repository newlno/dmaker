package com.programming.dmaker.controller;

import com.programming.dmaker.dto.request.DMakerRequestDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class DMakerController {

    private final DMakerService dMakerService;

    @PostMapping("/developers")
    public ResponseDto<?> createDeveloper(@RequestBody DMakerRequestDto requestBody) {
        return dMakerService.createDeveloper(requestBody);
    }
}
