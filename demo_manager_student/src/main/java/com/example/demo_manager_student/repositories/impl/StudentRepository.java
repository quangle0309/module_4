package com.example.demo_manager_student.repositories.impl;


import com.example.demo_manager_student.models.Student;
import com.example.demo_manager_student.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1L, "Học sinh 1","Đà Nẵng", 9.0f));
        students.add(new Student(2L, "Học sinh 2","Hà Tĩnh", 9.0f));
        students.add(new Student(3L, "Học sinh 3","Huế", 9.0f));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size()-1).getId() + 1);
        students.add(student);
    }

    @Override
    public Student getStudentById(Long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        for (Student st : students) {
            if (st.getId() == student.getId()) {
                st.setName(student.getName());
                st.setAddress(student.getAddress());
                st.setScore(student.getScore());
            }
        }
    }
}
