package com.example.demo_manager_student.services;

import com.example.demo_manager_student.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student getStudentById(Long id);

    void update(Student student);
}
