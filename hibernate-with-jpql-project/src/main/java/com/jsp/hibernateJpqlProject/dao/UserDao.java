package com.jsp.hibernateJpqlProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernateJpqlProject.dto.User;

/**
 * This class serves as the data access object (DAO) for User entities,
 * facilitating communication with the database.
 */
public class UserDao {
	// Creating EntityManagerFactory and EntityManager instances for database access
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateJpqlProject");
	EntityManager manager = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	/**
	 * Inserts a User entity into the database.
	 * 
	 * @param u User object to be inserted
	 * @return int value representing the number of affected rows
	 */
	public int insertData(User u) {
		transaction.begin();
		// Using a native SQL query to insert data
		int ra = manager.createNativeQuery("INSERT INTO user(name,email,dob,phone) VALUES(?,?,?,?)")
				.setParameter(1, u.getName()).setParameter(2, u.getEmail()).setParameter(3, u.getDob())
				.setParameter(4, u.getPhone()).executeUpdate();
		transaction.commit();
		return ra;

//    	transaction.begin();
//    	String str = "INSERT INTO user(name,email,dob,phone) VALUES(?,?,?,?)";
//    	Query query = manager.createNativeQuery(str);
//    	query.setParameter(1, u.getName());
//    	query.setParameter(2, u.getEmail());
//    	query.setParameter(3, u.getDob());
//    	query.setParameter(4, u.getPhone());
//    	int ra = query.executeUpdate();
//    	transaction.commit();
//    	return ra;
	}

	/**
	 * Updates a User entity in the database.
	 * 
	 * @param u User object with updated data
	 * @return int value representing the number of affected rows
	 */
	public int updateData(User u) {
		transaction.begin();
		// Using JPQL to update data
		int ra = manager.createQuery(
				"UPDATE User u SET u.name=:uname, u.email=:uemail, u.dob=:udob, u.phone=:uphone WHERE u.id=:uid")
				.setParameter("uname", u.getName()).setParameter("uemail", u.getEmail())
				.setParameter("udob", u.getDob()).setParameter("uphone", u.getPhone()).setParameter("uid", u.getId())
				.executeUpdate();
		transaction.commit();
		return ra;

//    	transaction.begin();
//    	String str = "UPDATE User u SET u.name=:uname, u.email=:uemail, u.dob=:udob, u.phone=:uphone WHERE u.id=:uid";
//    	Query query = manager.createQuery(str);
//    	query.setParameter("uname", u.getName());
//    	query.setParameter("uemail", u.getEmail());
//    	query.setParameter("udob", u.getDob());
//    	query.setParameter("uphone", u.getPhone());
//    	query.setParameter("uid", u.getId());
//    	int ra = query.executeUpdate();
//    	transaction.commit();
//    	return ra;
	}

	/**
	 * Deletes a User entity from the database based on its ID.
	 * 
	 * @param id ID of the user to be deleted
	 * @return int value representing the number of affected rows
	 */
	public int deleteUser(int id) {
		transaction.begin();
		// Using JPQL to delete data
		int ra = manager.createQuery("DELETE from User u WHERE u.id=:id").setParameter("id", id).executeUpdate();
		transaction.commit();
		return ra;

//    	transaction.begin();
//    	String str = "DELETE from User u WHERE u.id=:id";
//    	Query query = manager.createQuery(str);
//    	query.setParameter("id", id);
//    	int ra = query.executeUpdate();
//    	transaction.commit();
//    	return ra;
	}

	/**
	 * Retrieves a specific User entity from the database based on its ID.
	 * 
	 * @param id ID of the user to retrieve
	 * @return User object representing the retrieved user
	 */
	public User getUser(int id) {
		// Using JPQL to retrieve data
		return (User) manager.createQuery("SELECT u FROM User u WHERE u.id=:uid").setParameter("uid", id)
				.getSingleResult();

//    	String str = "SELECT u FROM User u WHERE u.id=:uid";
//    	Query query = manager.createQuery(str);
//    	query.setParameter("uid", id);
//    	User user = (User) query.getSingleResult();
//    	return user;
	}

	/**
	 * Retrieves all User entities from the database.
	 * 
	 * @return List of User objects representing all users in the database
	 */
	public List<User> getAll() {
		// Using JPQL to retrieve all data
		return manager.createQuery("SELECT u FROM User u", User.class).getResultList();

//    	String str = "SELECT u FROM User u";
//    	Query query = manager.createQuery(str, User.class);
//    	return query.getResultList();
	}
}
