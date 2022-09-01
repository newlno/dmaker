package com.programming.dmaker.controller;

import com.programming.dmaker.dto.request.DeveloperRequestDto;
import com.programming.dmaker.dto.response.ResponseDto;
import com.programming.dmaker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping("/api/developers")
    public ResponseDto<?> createDeveloper(@RequestBody DeveloperRequestDto requestDto) {
        return developerService.createDeveloper(requestDto);
    }

    @GetMapping("/api/developers")
    public ResponseDto<?> getAllDeveloper(){
        return developerService.getAllDeveloper();
    }

    @GetMapping("/api/developers/{developerId}")
    public ResponseDto<?> getDeveloper(@PathVariable Long developerId){
        return developerService.getDeveloper(developerId);
    }

    @PutMapping("/api/developers/{developerId}")
    public ResponseDto<?> updateDeveloper(@PathVariable Long developerId,
                                     @RequestBody DeveloperRequestDto requestDto){
        return developerService.updateDeveloper(developerId,requestDto);
    }

    @DeleteMapping("/api/developers/{developerId}")
    public ResponseDto<?> deleteDeveloper(@PathVariable Long developerId){
        return developerService.deleteDeveloper(developerId);
    }

}
