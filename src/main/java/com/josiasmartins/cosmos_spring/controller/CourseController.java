package com.josiasmartins.cosmos_spring.controller;

import com.josiasmartins.cosmos_spring.domain.DTO.CourseRequestDTO;
import com.josiasmartins.cosmos_spring.domain.DTO.CourseResponseDTO;
import com.josiasmartins.cosmos_spring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseDTO createCourse(@RequestBody CourseRequestDTO request) {
        return this.courseService.createCourse(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<CourseResponseDTO> listCourse() {
        return this.courseService.getCourses();
    }

}
