package com.josiasmartins.cosmos_spring.domain.DTO;

import com.josiasmartins.cosmos_spring.domain.entity.Course;
import lombok.Data;

@Data
public class CourseRequestDTO {

    private String productCategory;
    private String name;
    private long price;


}
