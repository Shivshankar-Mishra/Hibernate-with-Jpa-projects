package com.jsp.one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.one_to_one_uni.dto.Person;

/**
 * This class handles data access operations for the Person entity.
 * 
 * @author Shivshankar Mishra
 */
public class PersonDao {
    // EntityManagerFactory for creating EntityManager instances
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateOneTOOneUniProject");
    // EntityManager for interacting with the persistence context
    EntityManager manager = factory.createEntityManager();
    // EntityTransaction for managing transactions
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Inserts a new Person entity into the database.
     * 
     * @param person The Person entity to insert
     * @return The inserted Person entity
     */
    public Person insertData(Person person) {
        transaction.begin();
        manager.persist(person);
        transaction.commit();
        return person;
    }

    /**
     * Updates an existing Person entity in the database.
     * 
     * @param person The updated Person entity
     * @return The updated Person entity
     */
    public Person updateData(Person person) {
        Person pr = getPerson(person.getPid());
        // Update fields if not empty/null
        pr.setName((person.getName().isEmpty() ? pr.getName() : person.getName()));
        pr.setEmail((person.getEmail().isEmpty() ? pr.getEmail() : person.getEmail()));
        pr.setGender((person.getGender().isEmpty() ? pr.getGender() : person.getGender()));
        pr.setPhone((person.getPhone() <= 0 ? pr.getPhone() : person.getPhone()));
        pr.setAdhar((person.getAdhar() == null ? pr.getAdhar() : person.getAdhar()));
        transaction.begin();
        manager.merge(pr);
        transaction.commit();
        return pr;
    }

    /**
     * Deletes a Person entity from the database by its ID.
     * 
     * @param id The ID of the Person entity to delete
     */
    public void deleteData(int id) {
        transaction.begin();
        manager.remove(getPerson(id));
        transaction.commit();
    }

    /**
     * Retrieves a Person entity from the database by its ID.
     * 
     * @param id The ID of the Person entity to retrieve
     * @return The retrieved Person entity
     */
    public Person getPerson(int id) {
        return manager.find(Person.class, id);
    }

    /**
     * Retrieves all Person entities from the database.
     * 
     * @return A list of all Person entities
     */
    public List<Person> getAll() {
        return manager.createQuery("from Person", Person.class).getResultList();
    }
}
