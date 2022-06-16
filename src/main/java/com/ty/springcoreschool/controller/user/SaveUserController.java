package com.ty.springcoreschool.controller.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.MyConfig;
import com.ty.springcoreschool.dto.Student;
import com.ty.springcoreschool.dto.User;
import com.ty.springcoreschool.service.StudentService;
import com.ty.springcoreschool.service.UserService;

public class SaveUserController {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

		User user = new User();

		user.setName("Peter");
		user.setEmail("peter@mail.com");
		user.setPassword("1234");
		user.setPhone(77770000);
		user.setGender("Male");

		UserService userService = (UserService) applicationContext.getBean("userService");
		User user2 = userService.saveUser(user);

		if (user2 != null) {
			System.out.println("Inserted");
		} else {
			System.out.println("Not Inserted");
		}

	}

}
