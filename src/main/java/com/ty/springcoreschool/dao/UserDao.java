package com.ty.springcoreschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.springcoreschool.dto.User;

@Component
public class UserDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public User saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public User getUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(User.class, id);

	}

	public List<User> getAllUsers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from User u";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public User updateUser(User user, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user2 = entityManager.find(User.class, id);
		user2.setName(user.getName());

		entityTransaction.begin();
		entityManager.merge(user2);
		entityTransaction.commit();
		return user2;

	}

	public boolean deleteUser(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);

		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}

		return false;

	}

}
