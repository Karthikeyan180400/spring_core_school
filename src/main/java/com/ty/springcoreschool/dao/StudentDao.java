package com.ty.springcoreschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dto.Student;

@Component
public class StudentDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;

	}

	public Student getStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);

	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select s from Student s";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Student updateStudent(Student student, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student2 = entityManager.find(Student.class, id);
		student2.setName(student.getName());

		entityTransaction.begin();
		entityManager.merge(student2);
		entityTransaction.commit();
		return student2;

	}

	public boolean deleteStudent(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);

		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}

		return false;

	}

}
