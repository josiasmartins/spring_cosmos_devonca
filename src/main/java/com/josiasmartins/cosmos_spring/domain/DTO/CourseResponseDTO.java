package com.josiasmartins.cosmos_spring.domain.DTO;

import com.josiasmartins.cosmos_spring.domain.entity.Course;
import com.josiasmartins.cosmos_spring.repository.CourseRepository;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CourseResponseDTO {

    private String courseId;
    private String productCategory;
    private String name;
    private long price;

    public CourseResponseDTO(Course course) {
        this.courseId = course.getCourseId();
        this.productCategory = course.getProductCategory();
        this.name = course.getName();
        this.price = course.getPrice();
    }


}
