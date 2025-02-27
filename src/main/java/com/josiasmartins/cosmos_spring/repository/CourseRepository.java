package com.josiasmartins.cosmos_spring.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.josiasmartins.cosmos_spring.domain.entity.Course;
//import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CosmosRepository<Course, String> {

    List<Course> findByProductCategory(String productCategory);

    List<Course> findAll();

    Course save(Course course);

}
