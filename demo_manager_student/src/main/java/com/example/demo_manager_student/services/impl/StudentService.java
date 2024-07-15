package com.example.demo_manager_student.services.impl;

import com.example.demo_manager_student.models.Student;
import com.example.demo_manager_student.repositories.IStudentRepository;
import com.example.demo_manager_student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }
}
