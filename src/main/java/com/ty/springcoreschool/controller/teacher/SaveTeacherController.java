package com.ty.springcoreschool.controller.teacher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.MyConfig;
import com.ty.springcoreschool.dto.Student;
import com.ty.springcoreschool.dto.Teacher;
import com.ty.springcoreschool.service.StudentService;
import com.ty.springcoreschool.service.TeacherService;

public class SaveTeacherController {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Teacher teacher = new Teacher();
		teacher.setName("Nishanth");
		teacher.setEmail("nish@mail.com");
		teacher.setPassword("123");
		teacher.setPhone(71170000);
		teacher.setGender("Male");
		teacher.setSubject("JAVA");

		TeacherService teacherService = (TeacherService) applicationContext.getBean("teacherService");
		Teacher teacher2 = teacherService.saveTeacher(teacher);

		if (teacher2 != null) {
			System.out.println("Inserted");
		} else {
			System.out.println("Not Inserted");
		}

	}

}
