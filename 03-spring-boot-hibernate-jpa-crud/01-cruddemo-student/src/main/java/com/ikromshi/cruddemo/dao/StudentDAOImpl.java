package com.ikromshi.cruddemo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ikromshi.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
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
}