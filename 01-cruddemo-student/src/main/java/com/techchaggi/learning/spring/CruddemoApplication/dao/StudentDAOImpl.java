package com.techchaggi.learning.spring.CruddemoApplication.dao;

import com.techchaggi.learning.spring.CruddemoApplication.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entitiy mananger
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    // implements save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
