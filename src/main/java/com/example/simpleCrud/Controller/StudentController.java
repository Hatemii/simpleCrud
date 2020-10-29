package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Student;
import com.example.simpleCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET ALL STUDENTS
    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    // GET STUDENT BY ID    `                                                           `````````````````````````````
    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

    // DELETE STUDENT BY ID
    @DeleteMapping(value = "/delete/{id}")
    public void deletetStudentById(@PathVariable("id") int id) {
        this.studentService.deletetStudentById(id);
    }

    // UPDATE STUDENT
    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        this.studentService.updateStudent(id, student);
    }

    // INSERT STUDENT
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@Valid @RequestBody Student student) {
        this.studentService.insertStudent(student);
    }

    // Count
    @GetMapping(value = "/count")
    public int countStudents() {
        return this.studentService.countStudents();
    }


    // Delete all records
    @DeleteMapping
    @RequestMapping("/deleteAll")
    public void deleteAllRecords() {
        this.studentService.deleteAllRecords();
    }

    // delete all where name starts with
    @DeleteMapping
    @RequestMapping(value = "/deleteAll/{s}")
    public void deleteAllWhere(@PathVariable("s") String s) {
        this.studentService.deleteAllWhere(s);
    }

}
