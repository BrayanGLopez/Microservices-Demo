package com.blsolution.course.service;

import java.util.List;

import com.blsolution.course.http.response.StudentByCourseResponse;
import com.blsolution.course.model.Course;

public interface CourseSeervice {
	public List<Course> findAll();
	public Course findById(Long idCourse);
	public Course saveCourse(Course course);
	public String updateCourse(Long idCourse, Course course);
	public String deleteCourse(Long idCourse);
	public StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
