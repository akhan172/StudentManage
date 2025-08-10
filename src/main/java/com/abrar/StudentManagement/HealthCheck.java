package com.abrar.StudentManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abrar.StudentManagement.Entity.Student;

@RestController
@RequestMapping("/check")
public class HealthCheck {
	@GetMapping
	public String health() {
		Student s = new Student();
		s.setName("Abrar");
		return s.getName();
	}
}
