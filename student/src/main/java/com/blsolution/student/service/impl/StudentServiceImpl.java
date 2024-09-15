package com.blsolution.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blsolution.student.model.Student;
import com.blsolution.student.repository.StudentRepository;
import com.blsolution.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student findById(Long idStudent) {
		return this.studentRepository.findById(idStudent)
				.orElseThrow();
	}

	@Override
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public String updateStudent(Long idStudent, Student student) {
		
		Optional<Student> studeOptional = this.studentRepository.findById(idStudent);
		
		if(!studeOptional.isPresent()) {
			throw new RuntimeException("No se encontro el estudienate.");
		}
		
		student.setId(idStudent);		
		this.studentRepository.save(student);
		
		return "Actualizado con exitó!";
	}

	@Override
	public String deleteStudent(Long idStudent) {
	
		Optional<Student> studeOptional = this.studentRepository.findById(idStudent);
		
		if(!studeOptional.isPresent()) {
			throw new RuntimeException("No se encontro el estudienate.");
		}
		
		this.studentRepository.delete(studeOptional.get());
		
		return "Eliminado con exitó!";
	}

	@Override
	public List<Student> finAlldByCourseId(Long courseId) {
		return this.studentRepository.findAllByCourseId(courseId);
	}

}
