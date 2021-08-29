package com.example.studentservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.studentservice.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	private static List<Student> students = new ArrayList<>();
	static {
		students.add(new Student(1, "James"));
		students.add(new Student(2, "Carl"));
		students.add(new Student(3, "Anna"));
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public Student getStudent(int id) {
		return students.stream().findFirst().filter(student -> student.getId() == id).orElse(null);
	}

	public Student addStudent(Student student){
		students.add(student);
		return student;
	}
}
