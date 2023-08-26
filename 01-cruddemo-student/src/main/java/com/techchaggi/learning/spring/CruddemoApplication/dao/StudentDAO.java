package com.techchaggi.learning.spring.CruddemoApplication.dao;

import com.techchaggi.learning.spring.CruddemoApplication.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findByID(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
