package com.ikromshi.cruddemo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ikromshi.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    
    // define field for entity manager;
    private EntityManager entityManager;

    // inject entity manager using constructor injection;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method;
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // implement findById method;
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // implement findAll method;
    @Override
    public List<Student> findAll() {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return the query results
        return theQuery.getResultList();
    }

    // implement findByLastName method;
    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }
}
