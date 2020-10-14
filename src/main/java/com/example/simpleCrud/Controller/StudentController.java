package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Student;
import com.example.simpleCrud.Service.StudentService;

import java.util.Collection;

public class StudentController {
    private StudentService studentService;

    public Collection<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

}
