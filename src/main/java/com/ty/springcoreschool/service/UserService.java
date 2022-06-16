package com.ty.springcoreschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dao.TeacherDao;
import com.ty.springcoreschool.dao.UserDao;
import com.ty.springcoreschool.dto.Teacher;
import com.ty.springcoreschool.dto.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);

	}

	public User getUserById(int id) {
		return userDao.getUserById(id);

	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();

	}

	public User updateUser(User user, int id) {
		return userDao.updateUser(user, id);
	}

	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

}
