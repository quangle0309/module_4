package com.codegym.c0324h1_spring_boot_2.controllers;

import com.codegym.c0324h1_spring_boot_2.models.Student;
import com.codegym.c0324h1_spring_boot_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentRestController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    Put cập nhật toàn bộ
//    findById
//    save(student)
//    Patch cập nhật 1 phần hoặc toàn bộ
//    findById
//    Set cho từng thuộc tính thay đổi
//    save cho đối tương vừa findByID

    
//    @PatchMapping("/{id}")


//    Bài tập về nhà làm chức năng update và delete
//    Thứ 2 soạn slide thuyết trình bài Ajax
}
