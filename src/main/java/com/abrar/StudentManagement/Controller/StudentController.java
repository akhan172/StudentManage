package com.abrar.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abrar.StudentManagement.Entity.Student;
import com.abrar.StudentManagement.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Create Operations
	@PostMapping("/create")
	public Student createStudent(@Valid @RequestBody Student student ) {
		return studentService.saveStudent(student);
	}
	
	//Read Operations Read One and Read All
	@GetMapping("/readAll")
	public List<Student> readAllStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/readOne/{id}")
	public Student readStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	//Update Operations
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.updateStudentById(id, student);
	}
	
	//Delete Operations
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable int id) {
		return studentService.deleteStudentById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		studentService.deleteAll();
		System.out.println("All Student Data Deleted");
	}
}
