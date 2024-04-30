package com.jsp.hibernateJpqlProject.service;

import java.util.List;

import com.jsp.hibernateJpqlProject.dao.UserDao;
import com.jsp.hibernateJpqlProject.dto.User;

/**
 * This service class encapsulates business logic and validation for User
 * entities.
 * 
 * @author Shivshankar Mishra
 */
public class UserService {
	UserDao dao = new UserDao();

	/**
	 * Inserts a single User entity into the database.
	 * 
	 * @param u User object to be inserted
	 * @return int value representing the number of affected rows
	 */
	public int insertOneData(User u) {
		return dao.insertData(u);
	}

	/**
	 * Updates a single User entity in the database.
	 * 
	 * @param u User object with updated data
	 * @return int value representing the number of affected rows
	 */
	public int updateUserData(User u) {
		return dao.updateData(u);
	}

	/**
	 * Deletes a single User entity from the database based on its ID.
	 * 
	 * @param id ID of the user to be deleted
	 * @return int value representing the number of affected rows
	 */
	public int deleteUserData(int id) {
		return dao.deleteUser(id);
	}

	/**
	 * Retrieves a single User entity from the database based on its ID.
	 * 
	 * @param id ID of the user to retrieve
	 * @return User object representing the retrieved user
	 */
	public User getOneUser(int id) {
		return dao.getUser(id);
	}

	/**
	 * Retrieves all User entities from the database.
	 * 
	 * @return List of User objects representing all users in the database
	 */
	public List<User> getAllUser() {
		return dao.getAll();
	}
}
