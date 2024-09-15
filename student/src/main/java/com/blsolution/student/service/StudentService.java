package com.blsolution.student.service;

import java.util.List;

import com.blsolution.student.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(Long idStudent);
	public Student saveStudent(Student student);
	public String updateStudent(Long idStudent, Student student);
	public String deleteStudent(Long idStudent);
	public List<Student> finAlldByCourseId(Long courseId);
}
