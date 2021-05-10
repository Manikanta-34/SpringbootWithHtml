package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String getListStudents(Model model) {
		model.addAttribute("students", studentService.listOfStudents());
		return "students";
	}

	@GetMapping("/student/form")
	public String studentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "createStudent";
	}

	@PostMapping("/student/save")
	public String saveStudentData(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/student/editForm/{id}")
	public String studentEditForm(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editStudent";

	}

	@PostMapping("/student/update/{id}")
	public String updateStudentData(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student studentById = studentService.getStudentById(id);
		studentById.setFirstname(student.getFirstname());
		studentById.setLastname(student.getLastname());
		studentById.setEmail(student.getEmail());
		studentService.updatetudent(studentById);
		return "redirect:/students";
	}

	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
