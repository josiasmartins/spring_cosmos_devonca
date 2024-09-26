package com.josiasmartins.cosmos_spring.services;

import com.josiasmartins.cosmos_spring.domain.DTO.CourseRequestDTO;
import com.josiasmartins.cosmos_spring.domain.DTO.CourseResponseDTO;
import com.josiasmartins.cosmos_spring.domain.entity.Course;
import com.josiasmartins.cosmos_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<CourseResponseDTO> getCourses() {
        return this.repository.findAll().stream()
                .map(course -> new CourseResponseDTO(course))
                .toList();
    }

    public CourseResponseDTO createCourse(CourseRequestDTO request) {
        Course course = this.repository.save(new Course(request));
        return new CourseResponseDTO(course);
    }

}
