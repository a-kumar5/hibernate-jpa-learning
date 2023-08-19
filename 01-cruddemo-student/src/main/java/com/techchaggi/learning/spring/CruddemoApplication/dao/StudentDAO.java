package com.techchaggi.learning.spring.CruddemoApplication.dao;

import com.techchaggi.learning.spring.CruddemoApplication.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(Integer id);

    List<Student> findAll();
}
