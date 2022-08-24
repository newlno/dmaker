package com.programming.dmaker.controller;

import com.programming.dmaker.dto.request.DMakerRequestDto;
import com.programming.dmaker.dto.response.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DMakerController {

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {

    }

    @PostMapping("/developers")
    public ResponseDto<?> createDeveloper (@RequestBody DMakerRequestDto requestBody) {

    }
}
