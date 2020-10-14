package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;

import java.util.Collection;

public interface StudentDaoInterface {
    // GET ALL STUDENTS
    Collection<Student> getAllStudents();

    // GET STUDENT BY ID
    Student getStudentById(int id);

    // DELETE STUDENT BY ID
    void deletetStudentById(int id);

    // UPDATE STUDENT
    void updateStudent(Student student);

    // INSERT STUDENT
    void insertStudent(Student student);
}
