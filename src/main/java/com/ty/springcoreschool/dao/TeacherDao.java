package com.ty.springcoreschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dto.Teacher;

@Component
public class TeacherDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		return teacher;

	}

	public Teacher getTeacherById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Teacher.class, id);

	}

	public List<Teacher> getAllTeachers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select t from Teacher t";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Teacher updateTeacher(Teacher teacher, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher2 = entityManager.find(Teacher.class, id);
		teacher2.setName(teacher.getName());

		entityTransaction.begin();
		entityManager.merge(teacher2);
		entityTransaction.commit();
		return teacher2;

	}

	public boolean deleteTeacher(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = entityManager.find(Teacher.class, id);

		if (teacher != null) {
			entityTransaction.begin();
			entityManager.remove(teacher);
			entityTransaction.commit();
			return true;
		}

		return false;

	}

}
