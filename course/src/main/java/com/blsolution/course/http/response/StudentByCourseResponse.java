package com.blsolution.course.http.response;

import java.util.List;

import com.blsolution.course.dto.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentByCourseResponse {
	
	private String nameCourse;
	private String modality;
	private List<StudentDto> studentsDTO;

}
