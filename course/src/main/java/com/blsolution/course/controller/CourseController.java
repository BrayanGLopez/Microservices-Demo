package com.blsolution.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blsolution.course.model.Course;
import com.blsolution.course.service.CourseSeervice;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
	
	@Autowired
	private CourseSeervice courseSeervice;
	
	public ResponseEntity<List<Course>> findAll(){
		return ResponseEntity
				.ok(this.courseSeervice.findAll());
	}
	
	public ResponseEntity<Course> findById(Long idCourse){
		return ResponseEntity
				.ok(this.courseSeervice.findById(idCourse));
	}
	
	public ResponseEntity<Course> saveCourse(Course course){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.courseSeervice.saveCourse(course));
	}
	
	public ResponseEntity<String> updateCourse(Long idCourse, Course course){
		return ResponseEntity
				.ok(this.courseSeervice.updateCourse(idCourse, course));
	}
	
	public ResponseEntity<String> deleteCourse(Long idCourse){
		return ResponseEntity
				.ok(this.courseSeervice.deleteCourse(idCourse));
	}
}
