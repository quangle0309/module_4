package com.example.demo_manager_student.repositories;


import com.example.demo_manager_student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student getStudentById(Long id);

    void update(Student student);
}
