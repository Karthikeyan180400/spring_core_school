package com.ty.springcoreschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dao.StudentDao;
import com.ty.springcoreschool.dto.Student;

@Component
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);

	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);

	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();

	}

	public Student updateStudent(Student student, int id) {
		return studentDao.updateStudent(student, id);
	}

	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}

}
