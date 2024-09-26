package com.josiasmartins.cosmos_spring.domain.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.josiasmartins.cosmos_spring.domain.DTO.CourseRequestDTO;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
//import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@Container(containerName = "course")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private String courseId;
    @PartitionKey
    private String productCategory;
    private String name;
    private long price;

    public Course(CourseRequestDTO course) {
        this.productCategory = course.getProductCategory();
        this.name = course.getName();
        this.price = course.getPrice();
    }

}
