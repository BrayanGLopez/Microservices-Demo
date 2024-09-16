package com.blsolution.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blsolution.course.client.StudentClient;
import com.blsolution.course.dto.StudentDto;
import com.blsolution.course.http.response.StudentByCourseResponse;
import com.blsolution.course.model.Course;
import com.blsolution.course.repository.CourseRepository;
import com.blsolution.course.service.CourseSeervice;

@Service
public class CourseServiceImpl implements CourseSeervice{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentClient studentClient;
	
	@Override
	public List<Course> findAll() {
		return this.courseRepository.findAll();
	}

	@Override
	public Course findById(Long idCourse) {
		return this.courseRepository.findById(idCourse)
				.orElseThrow(() -> new RuntimeException("No se encontro el curso!"));
	}

	@Override
	public Course saveCourse(Course course) {
		return this.saveCourse(course);
	}

	@Override
	public String updateCourse(Long idCourse, Course course) {
		
		Course courseOptional = this.courseRepository.findById(idCourse)
				.orElseThrow(() -> new RuntimeException("No se encontro el curso!"));
					
		course.setId(idCourse);
		this.courseRepository.save(course);
		
		return "Actualizado con exitó!";
	}

	@Override
	public String deleteCourse(Long idCourse) {
		
		Course courseOptional = this.courseRepository.findById(idCourse)
				.orElseThrow(() -> new RuntimeException("No se encontro el curso!"));
					
		this.courseRepository.deleteById(idCourse);
		
		return "Eliminado con exitó!";
	}

	@Override
	public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
		
		Course course = this.courseRepository.findById(idCourse)
				.orElseThrow(() -> new RuntimeException("No existe el curso"));
		
		List<StudentDto> students = this.studentClient.finAlldByCourseId(idCourse);
		
		return StudentByCourseResponse
				.builder()
				.nameCourse(course.getName())
				.modality(course.getModality())
				.studentsDTO(students)
				.build();
	}

}
