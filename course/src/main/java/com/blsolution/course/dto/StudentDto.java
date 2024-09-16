package com.blsolution.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentDto {
	
	private String name;
	private String lastName;
	private String email;
	private String phone;
	private Long courseId;

}
