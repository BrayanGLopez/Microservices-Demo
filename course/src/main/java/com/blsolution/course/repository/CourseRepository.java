package com.blsolution.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blsolution.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
