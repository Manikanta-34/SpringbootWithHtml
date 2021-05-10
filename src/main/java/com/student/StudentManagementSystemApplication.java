package com.student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.model.Student;
import com.student.repo.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@PostConstruct
	public void saveStudentData() {
		List<Student> collect = Stream
				.of(new Student("Kadimi", "Venkatamanikanta", "abc@gmail.com"),
						new Student("K", "Pavan", "xyz@gmail.com"), new Student("R", "Sai", "pqr123@gmail.com"))
				.collect(Collectors.toList());
		studentRepository.saveAll(collect);

	}

}
