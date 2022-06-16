package com.ty.springcoreschool.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.MyConfig;
import com.ty.springcoreschool.dto.Student;
import com.ty.springcoreschool.service.StudentService;

public class SaveUserController {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Student student = new Student();
		student.setName("Peter");
		student.setEmail("peter@mail.com");
		student.setPhone(77770000);
		student.setAge(22);
		student.setGender("Male");
		student.setCountry("India");
		student.setAddress("2nd corss,BTM Layout");

		StudentService studentService = (StudentService) applicationContext.getBean("studentService");
		Student student2 = studentService.saveStudent(student);
		if (student2 != null) {
			System.out.println("Inserted");
		} else {
			System.out.println("Not Inserted");
		}
	}

}
