package com.jsp.one_to_one_uni.service;

import java.util.List;

import com.jsp.one_to_one_uni.dao.PersonDao;
import com.jsp.one_to_one_uni.dto.Person;

/**
 * This class provides service methods for managing Person entities.
 * 
 * @author Shivshankar Mishra
 */
public class PersonService {
    PersonDao dao = new PersonDao();

    /**
     * Inserts a new Person entity.
     * 
     * @param person The Person entity to insert
     * @return The inserted Person entity
     */
    public Person insertPersonData(Person person) {
        return dao.insertData(person);
    }

    /**
     * Updates an existing Person entity.
     * 
     * @param person The updated Person entity
     * @return The updated Person entity
     */
    public Person updatePersonData(Person person) {
        return dao.updateData(person);
    }

    /**
     * Deletes a Person entity by its ID.
     * 
     * @param id The ID of the Person entity to delete
     */
    public void deletePersonData(int id) {
        dao.deleteData(id);
    }

    /**
     * Retrieves a Person entity by its ID.
     * 
     * @param id The ID of the Person entity to retrieve
     * @return The retrieved Person entity
     */
    public Person getPersonData(int id) {
        return dao.getPerson(id);
    }

    /**
     * Retrieves all Person entities.
     * 
     * @return A list of all Person entities
     */
    public List<Person> getAllPerson() {
        return dao.getAll();
    }
}
