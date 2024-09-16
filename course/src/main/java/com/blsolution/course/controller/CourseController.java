package com.blsolution.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blsolution.course.http.response.StudentByCourseResponse;
import com.blsolution.course.model.Course;
import com.blsolution.course.service.CourseSeervice;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
	
	@Autowired
	private CourseSeervice courseSeervice;
	
	@GetMapping("/")
	public ResponseEntity<List<Course>> findAll(){
		return ResponseEntity
				.ok(this.courseSeervice.findAll());
	}
	
	@GetMapping("/{idCourse}")
	public ResponseEntity<Course> findById(@PathVariable(name = "idCourse") Long idCourse){
		return ResponseEntity
				.ok(this.courseSeervice.findById(idCourse));
	}
	
	@PostMapping("/")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.courseSeervice.saveCourse(course));
	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateCourse(@PathVariable(name = "idCourse") Long idCourse,
			@RequestBody Course course){
		return ResponseEntity
				.ok(this.courseSeervice.updateCourse(idCourse, course));
	}
	
	@DeleteMapping("/{idCourse}")
	public ResponseEntity<String> deleteCourse(@PathVariable(name = "idCourse")Long idCourse){
		return ResponseEntity
				.ok(this.courseSeervice.deleteCourse(idCourse));
	}
	
	@GetMapping("/studentsbycourse/{idCourse}")
	public ResponseEntity<StudentByCourseResponse> findStudentsByIdCourse(@PathVariable(name = "idCourse") Long idCourse){
		return ResponseEntity
				.ok(this.courseSeervice.findStudentsByIdCourse(idCourse));
	}
}
