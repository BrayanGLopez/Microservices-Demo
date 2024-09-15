package com.blsolution.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blsolution.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findAllByCourseId(Long idCourse);
}
