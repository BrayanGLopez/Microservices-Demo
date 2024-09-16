package com.blsolution.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.blsolution.course.dto.StudentDto;


@FeignClient(name = "microservice-student", url = "localhost:8091/api/v1/students")
public interface StudentClient {
	
	@GetMapping("/allstudentscourse/{courseId}")
	public List<StudentDto> finAlldByCourseId(@PathVariable("courseId") Long courseId);
}
