package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Student;
import com.example.simpleCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public Collection<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

}
