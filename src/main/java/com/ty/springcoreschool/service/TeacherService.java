package com.ty.springcoreschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dao.TeacherDao;
import com.ty.springcoreschool.dto.Teacher;

@Component
public class TeacherService {

	@Autowired
	TeacherDao teacherDao;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherDao.saveTeacher(teacher);

	}

	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacherById(id);

	}

	public List<Teacher> getAllTeachers() {
		return teacherDao.getAllTeachers();

	}

	public Teacher updateTeacher(Teacher teacher, int id) {
		return teacherDao.updateTeacher(teacher, id);
	}

	public boolean deleteTeacher(int id) {
		return teacherDao.deleteTeacher(id);
	}

}
