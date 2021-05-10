package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> listOfStudents() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student student) {
		studentRepository.save(student);

	}

	public Student getStudentById(int id) {
		Student findById = studentRepository.findById(id).get();
		return findById;

	}

	public void updatetudent(Student student) {
		studentRepository.save(student);

	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);

	}

}
