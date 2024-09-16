package com.blsolution.student.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blsolution.student.model.Student;
import com.blsolution.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> findAll(){
		return ResponseEntity
				.ok(this.studentService.findAll()); 
	}
	
	@GetMapping("/{idStudet}")
	public ResponseEntity<Student> findById(@PathVariable(name = "idStudet") Long idStudent) {
		return ResponseEntity
				.ok(this.studentService.findById(idStudent));
	}
	
	@PostMapping("/")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.studentService.saveStudent(student));
	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateStudent(@RequestParam(name = "idStudent") Long idStudent,
								@RequestBody Student student) {
		return ResponseEntity
				.ok(this.studentService.updateStudent(idStudent, student));
	}
	
	@DeleteMapping("/{idStudent}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "idStudent") Long idStudent) {
		return ResponseEntity
				.ok(this.studentService.deleteStudent(idStudent));
	}
	
	@GetMapping("/allstudentscourse/{courseId}")
	public ResponseEntity<List<Student>> finAlldByCourseId(@PathVariable("courseId") Long courseId){
		return ResponseEntity
				.ok(this.studentService.finAlldByCourseId(courseId));
	}	
}
