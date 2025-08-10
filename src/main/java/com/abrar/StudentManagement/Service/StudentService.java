package com.abrar.StudentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abrar.StudentManagement.Entity.Student;
import com.abrar.StudentManagement.ExceptionHandler.DuplicateEmailException;
import com.abrar.StudentManagement.ExceptionHandler.ResourceNotFoundException;
import com.abrar.StudentManagement.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo; 
    
	//Inserting the Student
	public Student saveStudent(Student student) {
	
		
		if(studentRepo.existsByEmail(student.getEmail())) {
			throw new DuplicateEmailException("Entry Exist with same Email "+student.getEmail());
		}
		return studentRepo.save(student);
	}
	
	//Reading All Student
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	//Reading Student By ID
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No Student with such ID "+id));
	}
	
	//Update the Student
	public Student updateStudentById(int id, Student newStudent) {
		Student Old = getStudentById(id);
			Old.setName(newStudent.getName()!=null && !newStudent.getName().equals("")?newStudent.getName():Old.getName() );
			Old.setEmail(newStudent.getEmail()!=null && !newStudent.getEmail().equals("")?newStudent.getEmail():Old.getEmail() );
			Old.setCourse(newStudent.getCourse()!=null && !newStudent.getCourse().equals("")?newStudent.getCourse():Old.getCourse() );
			Old.setAge(newStudent.getAge()>0?newStudent.getAge():Old.getAge() );
			return studentRepo.save(Old);
		
		
	}
	
	public boolean deleteStudentById(int id) {
		Student Stu = getStudentById(id);
			studentRepo.delete(Stu);
			return true;
	}
	
	public void deleteAll() {
		studentRepo.deleteAll();
	}
}









































