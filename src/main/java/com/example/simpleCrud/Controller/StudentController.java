package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Student;
import com.example.simpleCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET ALL STUDENTS
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    // GET STUDENT BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

    // DELETE STUDENT BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletetStudentById(@PathVariable("id") int id) {
        this.studentService.deletetStudentById(id);
    }

    // UPDATE STUDENT
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        this.studentService.updateStudent(id, student);
    }

    // INSERT STUDENT
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {
        this.studentService.insertStudent(student);
    }
}
